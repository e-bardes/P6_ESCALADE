// pas encore utilisé

package com.openclassroom.escalade.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.EmpruntTopo;
import com.openclassroom.escalade.domain.EmpruntTopoKey;
import com.openclassroom.escalade.domain.Topo;
import com.openclassroom.escalade.domain.Utilisateur;
import com.openclassroom.escalade.repository.EmpruntTopoRepository;
import com.openclassroom.escalade.repository.TopoRepository;

@Service("topoService")
public class TopoServiceImpl implements TopoService {

	private TopoRepository repository;

	@Autowired
	public void setRepository(TopoRepository repository) {
		this.repository = repository;
	}

	private EmpruntTopoRepository empruntTopoRepository;

	@Autowired
	public void setEmpruntTopoRepository(EmpruntTopoRepository empruntTopoRepository) {
		this.empruntTopoRepository = empruntTopoRepository;
	}

	public TopoServiceImpl() {
	}

	@Override
	public List<Topo> getAllToposOfAUser(Long id) {
		return repository.findByUserId(id);
	}

	@Override
	public List<Topo> getAllToposDisponiblesWhichDontBelongToTheCurrentUser(Long utilisateurId) {
		return repository.findByIsDisponibleAndNotBelongToTheCurrentUser(utilisateurId);
	}

	@Override
	@Transactional
	public void addTopo(String nom, String departement, String date, String isDisponible, String description,
			Utilisateur utilisateur) {
		Topo topo = new Topo(nom, departement, LocalDate.parse(date), Boolean.parseBoolean(isDisponible), description);
		EmpruntTopo empruntTopo = new EmpruntTopo(topo, utilisateur);
		repository.save(topo);
		EmpruntTopoKey id = new EmpruntTopoKey(true, true, topo.getId(), utilisateur.getId());
		empruntTopo.setId(id);
		empruntTopoRepository.save(empruntTopo);
	}

	@Override
	@Transactional
	public void modifierDisponibilite(String topoId) {
		Long id = Long.parseLong(topoId);

		Topo topo = repository.findById(id).orElse(null);

		if (topo.isDisponible())
			repository.updateDisponibilite(id, false);
		else
			repository.updateDisponibilite(id, true);
	}

	@Override
	@Transactional
	public void demandeDeReservation(String topoId, Utilisateur utilisateur) {
		Topo topo = repository.findById(Long.parseLong(topoId)).orElse(null);
		EmpruntTopo empruntTopo = new EmpruntTopo(topo, utilisateur);
		EmpruntTopoKey id = new EmpruntTopoKey(false, false, topo.getId(), utilisateur.getId());
		empruntTopo.setId(id);
		empruntTopoRepository.save(empruntTopo);
	}

	@Override
	public List<EmpruntTopo> getAllDemandesDeReservationOfAUser(Long id) {
		return empruntTopoRepository.findByNotIsPossesseurAndNotIsPossedeAndUtilisateurId(id);

	}

	@Override
	public List<Topo> getAllReservationDemandsSendOfAUser(Long utilisateurId) {
		return repository.findByReservationDemandsSendOfAUser(utilisateurId);
	}

	@Override
	@Transactional
	public void attribuerTopo(Long utilisateurId, String topoId) {
		empruntTopoRepository.updateIsPossede(utilisateurId, Long.parseLong(topoId));
	}

}