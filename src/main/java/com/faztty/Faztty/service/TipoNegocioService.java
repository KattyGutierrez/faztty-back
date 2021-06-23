package com.faztty.Faztty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faztty.Faztty.entity.TipoNegocio;
import com.faztty.Faztty.repository.TipoNegocioRepository;

@Service
public class TipoNegocioService {
	@Autowired
	TipoNegocioRepository repo;
	
	public TipoNegocio getTipoNegocio(Long id) {
		return repo.findById(id).get();
	}
	
	public Iterable<TipoNegocio> getTipoNegocios(){
		return repo.findAll();
	}
	public TipoNegocio modificarTipoNegocio(TipoNegocio tn, Long id) {
		TipoNegocio tne= repo.findById(id).get();
		tne.setDescripcion(tn.getDescripcion());
		tne.setNombre(tn.getNombre());
		repo.save(tne);
		
		return tne;
	}
}
