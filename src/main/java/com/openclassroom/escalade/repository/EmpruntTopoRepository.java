package com.openclassroom.escalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.EmpruntTopo;

@Repository("empruntTopoRepository")
public interface EmpruntTopoRepository extends JpaRepository<EmpruntTopo, Long> {

	@Query("SELECT e FROM EmpruntTopo e WHERE e.id.isPossede = false AND e.id.isPossesseur = false AND e.id.topoId IN "
			+ "(SELECT e.id.topoId FROM EmpruntTopo e WHERE e.id.isPossesseur = true AND e.id.utilisateurId = ?1)")
	List<EmpruntTopo> findByNotIsPossesseurAndNotIsPossedeAndUtilisateurId(Long utilisateurId);

//	@Modifying
//	@Query("UPDATE EmpruntTopo e SET e.id.isPossede = true WHERE (e.id.utilisateurId = ?1 AND e.id.topoId = ?2) "
//			+ "AND (e.id.isPossede = false WHERE e.id.isPossesseur = true AND e.id.topoId = ?2 AND e.id.utilisateurId "
//			+ "IN (SELECT e FROM EmpruntTopo e WHERE e.id.topoId = ?2))")
//	void updateIsPossede(Long utilisateurId, Long topoId);

	@Modifying
	@Query("UPDATE EmpruntTopo e SET e.id.isPossede = CASE"
			+ " WHEN e.id.utilisateurId = ?1 AND e.id.topoId = ?2 THEN true"
			+ " WHEN e.id.isPossesseur = true AND e.id.topoId = ?2 AND e.id.utilisateurId IN "
			+ "(SELECT e.id.utilisateurId FROM EmpruntTopo e WHERE e.id.topoId = ?2) THEN false ELSE e.id.isPossede END")
	void updateIsPossede(Long utilisateurId, Long topoId);

}
