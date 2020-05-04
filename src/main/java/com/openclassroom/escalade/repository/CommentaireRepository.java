package com.openclassroom.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.Commentaire;

@Transactional(readOnly = true)
@Repository("commentaireResitory")
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

}
