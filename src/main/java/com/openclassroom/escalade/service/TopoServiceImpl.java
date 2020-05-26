// pas encore utilisé

package com.openclassroom.escalade.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.Topo;
import com.openclassroom.escalade.repository.TopoRepository;

@Service("topoService")
public class TopoServiceImpl implements TopoService {
	
	private TopoRepository repository;

	public TopoServiceImpl() {
		System.out.println("TopoServiceImpl no args contructor");	
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("Topo initialize");
		Topo topo1 = new Topo("region1");
		Topo topo2 = new Topo("region2");
		
		List<Topo> listeTopos = Arrays.asList(topo1, topo2);
		repository.saveAll(listeTopos);
	}
	
	
	public List<Topo> getAllTopos() {
		return repository.findAll();
	}
	
	public Optional<Topo> findById(Long id) {
		return repository.findById(id);
	}

	// injection de dépendances
	public TopoRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(TopoRepository repository) {
		System.out.println("TopoRepository setter");
		this.repository = repository;
	}
}