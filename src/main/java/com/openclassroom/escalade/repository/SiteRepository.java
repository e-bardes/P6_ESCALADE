package com.openclassroom.escalade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.Site;

@Transactional(readOnly = true)
@Repository("siteRepository")
public interface SiteRepository extends JpaRepository<Site, Long> { 

	
	Optional<Site> findById(Long id);
	
	@Override List<Site> findAll();
}
