// pas encore utilisé

package com.openclassroom.escalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Topo;

@Repository("topoRepository")
public interface TopoRepository extends JpaRepository<Topo, Long> {

//	List<Topo> findByUtilisateurOrderByIdAsc();

	// List<Topo> findByOrderByIdAsc();

	@Query("SELECT t FROM Topo t WHERE t.isDisponible = true "
			+ "AND (t.id NOT IN (SELECT e.id.topoId FROM EmpruntTopo e WHERE e.id.utilisateurId = ?1) OR t.id IN "
			+ "(SELECT e.id.topoId FROM EmpruntTopo e WHERE e.id.isPossesseur = false AND e.id.isPossede = false))")
	List<Topo> findByIsDisponibleAndNotBelongToTheCurrentUser(Long utilisateurId);

//	@Query("SELECT t FROM Topo t WHERE t.isDisponible = true "
//			+ "AND t.id NOT IN (SELECT e.id.topoId FROM EmpruntTopo e WHERE e.id.utilisateurId = ?1)")
//	List<Topo> findByIsDisponibleAndNotBelongOrReservedByTheCurrentUser(Long utilisateurId);

	@Query("SELECT t FROM Topo t WHERE t.id IN (SELECT e.id.topoId FROM EmpruntTopo e WHERE e.id.utilisateurId = ?1 "
			+ "AND (e.id.isPossesseur = true OR e.id.isPossede = true))")
	List<Topo> findByUserId(Long utilisateurId);

	@Query("SELECT t FROM Topo t WHERE t.id IN (SELECT e.id.topoId FROM EmpruntTopo e WHERE e.id.utilisateurId = ?1 "
			+ "AND e.id.isPossesseur = false)")
	List<Topo> findByReservationDemandsSendOfAUser(Long utilisateurId);

	@Modifying
	@Query("UPDATE Topo t SET t.isDisponible = ?2 WHERE t.id = ?1")
	void updateDisponibilite(Long id, boolean isDisponible);
}
