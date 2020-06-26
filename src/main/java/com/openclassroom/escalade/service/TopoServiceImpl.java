// pas encore utilisé

package com.openclassroom.escalade.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.Topo;
import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.repository.TopoRepository;
import com.openclassroom.escalade.repository.UtilisateurRepository;

@Service("topoService")
public class TopoServiceImpl implements TopoService {

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

	public TopoServiceImpl() {
	}

	@Override
	public List<Topo> getAllToposOfAUser(Long utilisateurId) {
		return repository.findAllToposOwnedOrPossessed(utilisateurId);
	}

//	@Override
//	public List<Topo> getAllToposDisponiblesWhichDontBelongToTheCurrentUser(Long utilisateurId) {
//		return repository.findByIsDisponibleAndNotBelongToTheCurrentUser(utilisateurId);
//	}

	@Override
	public List<Topo> getAllToposDisponiblesWhichDontBelongToTheCurrentUser(Long utilisateurId) {
		return repository.findAllAvailableTopoWhichNotBelongToTheCurrentUser(utilisateurId);
	}

	@Override
	@Transactional
	public void addTopo(String nom, String departement, String date, String description, String isDisponible,
			Long utilisateurId) {
//		Topo topo = new Topo(nom, departement, LocalDate.parse(date), Boolean.parseBoolean(isDisponible), description);
//		EmpruntTopo empruntTopo = new EmpruntTopo(topo, utilisateur);
//		repository.save(topo);
//		EmpruntTopoKey id = new EmpruntTopoKey(true, true, topo.getId(), utilisateur.getId());
//		empruntTopo.setId(id);
//		empruntTopoRepository.save(empruntTopo);

//		Topo topo = new Topo(nom, departement, LocalDate.parse(date), description);
//		repository.save(topo);
//		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
//		utilisateur.getOwnedTopoList().add(topo);
//		utilisateur.getPossessedTopoList().add(topo);
//		utilisateurRepository.save(utilisateur);

		Topo topo = new Topo(nom, departement, LocalDate.parse(date), description);
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
//		Topo topo = repository.findById(Long.parseLong(topoId)).orElse(null);
//		EmpruntTopo empruntTopo = new EmpruntTopo(topo, utilisateur);
//		EmpruntTopoKey id = new EmpruntTopoKey(false, false, topo.getId(), utilisateur.getId());
//		empruntTopo.setId(id);
//		empruntTopoRepository.save(empruntTopo);

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

//	@Override
//	@Transactional
//	public void attribuerTopo(Long utilisateurId, String topoId) {
//		empruntTopoRepository.updateIsPossede(utilisateurId, Long.parseLong(topoId));
//	}

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