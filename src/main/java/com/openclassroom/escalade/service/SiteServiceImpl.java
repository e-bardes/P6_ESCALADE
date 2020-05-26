package com.openclassroom.escalade.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.Site;
import com.openclassroom.escalade.repository.SiteRepository;

@Service("siteService")
public class SiteServiceImpl implements SiteService{
	
	// private final static Logger logger = LogManager.getLogger();
	
	private SiteRepository repository;
	
	private TopoService topoService;
	
	public SiteServiceImpl() {
		System.out.println("SiteServiceImpl no args contructor");
	}

	@PostConstruct
	public void initialize() {
		System.out.println("Site initialize");
		Site site1 = new Site("nom1", true);
		Site site2 = new Site("nom2");
		Site site3 = new Site("nom3", false);
		Site site4 = new Site("nom4", false);
		Site site5 = new Site("nom5", true);
		site1.setTopo(topoService.findById(1l).orElse(null));
		site2.setTopo(topoService.findById(2l).orElse(null));
		site3.setTopo(topoService.findById(1l).orElse(null));
		site4.setTopo(topoService.findById(2l).orElse(null));
		site5.setTopo(topoService.findById(1l).orElse(null));
		List<Site> listeSites = Arrays.asList(site1, site2, site3, site4, site5);
		repository.saveAll(listeSites);
	}
	
	public SiteRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(SiteRepository repository) {
		System.out.println("SiteRepository setter");
		this.repository = repository;
	}
	
	public TopoService getTopoService() {
		return topoService;
	}
	
	@Autowired
	public void setTopoService(TopoService topoService) {
		System.out.println("TopoService Setter dans Site");
		this.topoService = topoService;
	}

	@Override
	public Optional<Site> getSiteDetails(String siteId) {
		return repository.findById(Long.parseLong(siteId));
	}
	

	@Override
	public List<Site> getAllSites() {
		return repository.findAll();
	}

	@Override
	public List<Site> findAll() {
		return repository.findAll();
	}
}
