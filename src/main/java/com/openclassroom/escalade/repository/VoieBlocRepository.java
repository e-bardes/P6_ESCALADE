package com.openclassroom.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassroom.escalade.domain.VoieBloc;

@Transactional(readOnly = true)
@Repository("voieBlocRepository")
public interface VoieBlocRepository extends JpaRepository<VoieBloc, Long> {

}
