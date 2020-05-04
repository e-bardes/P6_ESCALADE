package com.openclassroom.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.Topo;

@Transactional(readOnly = true)
@Repository("topoRepository")
public interface TopoRepository extends JpaRepository<Topo, Long> {
	
	
	// public Optional<Topo> findById(Long id);
}

