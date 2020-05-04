package com.openclassroom.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.VoieFalaise;

@Transactional(readOnly = true)
@Repository("voieFalaiseRepository")
public interface VoieFalaiseRepository extends JpaRepository<VoieFalaise, Long> {

}
