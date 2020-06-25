// pas encore utilisé

package com.openclassroom.escalade.service;

import java.util.List;

import com.openclassroom.escalade.domain.EmpruntTopo;
import com.openclassroom.escalade.domain.Topo;
import com.openclassroom.escalade.domain.Utilisateur;

public interface TopoService {

	List<Topo> getAllToposOfAUser(Long id);

	List<Topo> getAllToposDisponiblesWhichDontBelongToTheCurrentUser(Long utilisateurId);

	List<Topo> getAllReservationDemandsSendOfAUser(Long utilisateurId);

	void demandeDeReservation(String topoId, Utilisateur utilisateur);

	void addTopo(String nom, String departement, String date, String isDisponible, String description,
			Utilisateur utilisateur);

	void modifierDisponibilite(String topoId);

	List<EmpruntTopo> getAllDemandesDeReservationOfAUser(Long id);

	void attribuerTopo(Long utilisateurId, String topoId);
}
