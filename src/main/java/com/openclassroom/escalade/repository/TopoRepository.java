package com.openclassroom.escalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Topo;
import com.openclassroom.escalade.domain.Utilisateur;

@Repository("topoRepository")
public interface TopoRepository extends JpaRepository<Topo, Long> {

	/*
	 * Cette méthode permet de récupérer tous les topos indiqués comme disponible de
	 * tous les utilisateurs excepté l'utilisateur courant (passé en paramètre).
	 */
	@Query("SELECT t FROM Topo t WHERE t.possessor = null AND t.owner.id != ?1")
	List<Topo> findAllAvailableTopoWhichNotBelongToTheCurrentUser(Long utilisateurId);

	/*
	 * Cette méthode permet de récupérer tous les topos dont l'utilisateur passé en
	 * paramètre (utilisateur courant) est propriétaire et également ceux qu'il
	 * emprunte actuellement.
	 */
	@Query("SELECT t FROM Topo t WHERE t.owner.id = ?1 OR (t.possessor.id != t.owner.id AND t.possessor.id is not null)")
	List<Topo> findAllToposOwnedOrPossessed(Long utilisateurId);

	/*
	 * Cette méthode permet de récupérer tous les topos dont la liste des personnes
	 * qui ont fait une demande de réservation contient l'utilisateur passé en
	 * paramètre (l'utilisateur courant dans le cadre de ce projet). Ainsi tous les
	 * demandes de réservation d'un seul utilisateur seront obtenus.
	 */
	@Query("SELECT t FROM Topo t WHERE ?1 MEMBER OF t.applicantList")
	List<Topo> findAllToposDemandsOfAUser(Utilisateur utilisateur);

	/* Cette méthode permet de modifier le possesseur d'un topo sélectionné */
	@Modifying
	@Query("UPDATE Topo t SET t.possessor.id = ?2 WHERE t.id = ?1")
	void updateDisponibilite(Long id, Long utilisateurId);

	/*
	 * Cette méthode permet de récupérer tous les topos dont l'utilisateur passé en
	 * paramètre (courant) est propriétaire et dont au moins 1 demande de
	 * réservation a été créée.
	 */
	@Query("SELECT t FROM Topo t WHERE t.owner.id = ?1 AND t.applicantList IS NOT EMPTY")
	List<Topo> findAllTopoOwnedByTheCurrentUserAndRequestedByUsers(Long utilisateurId);
}
