package com.openclassroom.escalade.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.Departement;
import com.openclassroom.escalade.domain.Topo;
import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.repository.TopoRepository;
import com.openclassroom.escalade.repository.UtilisateurRepository;

@Service("gestionTopoService")
public class GestionTopoServiceImpl implements GestionTopoService {

	private TopoRepository repository;

	@Autowired
	public void setRepository(TopoRepository repository) {
		this.repository = repository;
	}

	private UtilisateurRepository utilisateurRepository;

	@Autowired
	public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public GestionTopoServiceImpl() {
	}

	@Override
	public List<Topo> getAllToposOfAUser(Long utilisateurId) {
		return repository.findAllToposOwnedOrPossessed(utilisateurId);
	}

	@Override
	public List<Topo> getAllToposDisponiblesWhichDontBelongToTheCurrentUser(Long utilisateurId) {
		return repository.findAllAvailableTopoWhichNotBelongToTheCurrentUser(utilisateurId);
	}

	@Override
	@Transactional
	public void addTopo(String nom, String valeurDepartement, String date, String description, String isDisponible,
			Long utilisateurId) {

		Topo topo = new Topo(nom, Departement.from(valeurDepartement), LocalDate.parse(date), description);
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);

		topo.setOwner(utilisateur);

		if (isDisponible == null)
			topo.setPossessor(utilisateur);

		repository.save(topo);
	}

	@Override
	@Transactional
	public void modifierDisponibilite(String topoId, Long utilisateurId) {
		Long id = Long.parseLong(topoId);

		Topo topo = repository.findById(id).orElse(null);

		if (topo.getPossessor() == null) {
			repository.updateDisponibilite(id, utilisateurId);
			Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
			// quand un demande est acceptée alors toutes les autres sont rejetés
			// automatiquement
			topo.getApplicantList().clear();
			topo.getApplicantList().add(utilisateur);
			repository.save(topo);
		} else {
			repository.updateDisponibilite(id, null);
		}
	}

	@Override
	@Transactional
	public void demandeDeReservation(String topoId, Long utilisateurId) {
		Topo topo = repository.findById(Long.parseLong(topoId)).orElse(null);
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
		topo.getApplicantList().add(utilisateur);
		repository.save(topo);
	}

	@Override
	public List<Topo> getAllDemandesDeReservationReceveidOfAUser(Long utilisateurId) {
		return repository.findAllTopoOwnedByTheCurrentUserAndRequestedByUsers(utilisateurId);

	}

	@Override
	public List<Topo> getAllReservationDemandsSendOfAUser(Utilisateur utilisateur) {
		return repository.findAllToposDemandsOfAUser(utilisateur);
	}

	@Override
	@Transactional
	public void deleteAReservationDemand(String topoId, String utilisateurId) {

		Topo topo = repository.findById(Long.parseLong(topoId)).orElse(null);
		Long uId = Long.parseLong(utilisateurId);

		for (Utilisateur u : topo.getApplicantList()) {
			if (u.getId() == uId) {
				topo.getApplicantList().remove(u);
				repository.save(topo);
				break;
			}
		}
	}
}