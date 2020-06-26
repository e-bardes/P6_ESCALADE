// pas encore utilisé

package com.openclassroom.escalade.service;

import java.util.List;

import com.openclassroom.escalade.domain.Topo;
import com.openclassroom.escalade.domain.Utilisateur;

public interface TopoService {

	List<Topo> getAllToposOfAUser(Long id);

	List<Topo> getAllToposDisponiblesWhichDontBelongToTheCurrentUser(Long utilisateurId);

	List<Topo> getAllReservationDemandsSendOfAUser(Utilisateur utilisateur);

	void demandeDeReservation(String topoId, Long utilisateurId);

	void addTopo(String nom, String departement, String date, String description, String isDisponible,
			Long utilisateurId);

	void modifierDisponibilite(String topoId, Long utilisateurId);

	List<Topo> getAllDemandesDeReservationReceveidOfAUser(Long utilisateurId);

//	void attribuerTopo(Long utilisateurId, String topoId);

	void deleteAReservationDemand(String topoId, String utilisateurId);
}
