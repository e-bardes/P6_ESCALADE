package com.openclassroom.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.Longueur;

@Transactional(readOnly = true)
@Repository("longueurRepository")
public interface LongueurRepository extends JpaRepository<Longueur, Long> {

}
