package com.openclassroom.escalade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Site;


@Repository("siteRepository")
public interface SiteRepository extends JpaRepository<Site, Long> { 

	@Override
	Optional<Site> findById(Long id);
	
	@Override List<Site> findAll();
	
}
