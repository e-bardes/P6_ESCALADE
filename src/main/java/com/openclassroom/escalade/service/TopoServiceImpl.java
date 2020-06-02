// pas encore utilisé

package com.openclassroom.escalade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.escalade.domain.Topo;
import com.openclassroom.escalade.repository.TopoRepository;

@Service("topoService")
public class TopoServiceImpl implements TopoService {
	
	private TopoRepository repository;

	public TopoServiceImpl() {
	}
	
	public List<Topo> getAllTopos() {
		return repository.findAll();
	}

	// injection de dépendances
	public TopoRepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(TopoRepository repository) {
		this.repository = repository;
	}
}