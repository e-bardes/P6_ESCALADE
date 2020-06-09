package com.openclassroom.escalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.CotationFalaise;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Voie;

@Repository("voieRepository")
public interface VoieRepository extends JpaRepository<Voie, Long>{

	List<Voie> findByCotationBloc(@Param("cotation") CotationBloc cotation);
	
	List<Voie> findByCotationFalaise(@Param("cotation") CotationFalaise cotation);
	
//	@Query("SELECT v FROM Voie v WHERE v.getCotationBloc() = :cotation OR v.getCotationFalaise() = :cotation")
//	List<Voie> findByCotation(@Param("cotation") CotationBloc cotation);

//	@Query("SELECT v, s FROM Voie v, Site s WHERE v.secteur.s IN ?1 OR v.s IN ?1")
//	List<Site> findBySiteIn(List<Site> site);
	
	long countBySite(Site site);
	
}


