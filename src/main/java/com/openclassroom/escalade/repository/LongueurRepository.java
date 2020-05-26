// pas encore utilisé

package com.openclassroom.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.Longueur;

@Repository("longueurRepository")
public interface LongueurRepository extends JpaRepository<Longueur, Long> {

}
