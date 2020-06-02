package com.openclassroom.escalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.openclassroom.escalade.domain.CotationBloc;
import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.domain.Voie;

@Repository("voieRepository")
public interface VoieRepository extends JpaRepository<Voie, Long>{

	
//	@Query("SELECT v FROM Voie v WHERE v.cotationBloc.getValeurCotation() = :cotation  OR v.cotationFalaise.getValeurCotation() = :cotation")
//	List<Voie> findByCotation(@Param("cotation") String cotation);
	
	@Query("SELECT v FROM Voie v WHERE v.getCotationBloc() = :cotation OR v.getCotationFalaise() = :cotation")
	List<Voie> findByCotation(@Param("cotation") CotationBloc cotation);

//	@Query("SELECT v FROM Voie v WHERE v.secteur.site IN ?1 OR v.site IN ?1")
//	List<Voie> findBySiteIn(List<Site> site);
	
	long countBySite(Site site);
	
}


