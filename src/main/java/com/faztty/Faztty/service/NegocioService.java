package com.faztty.Faztty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faztty.Faztty.entity.Negocio;
import com.faztty.Faztty.entity.TipoNegocio;
import com.faztty.Faztty.repository.NegocioRepository;
import com.faztty.Faztty.repository.TipoNegocioRepository;

@Service
public class NegocioService {

	@Autowired
	NegocioRepository repoNegocio;
	@Autowired
	TipoNegocioRepository repoTipo;
	
	public Iterable<Negocio> getNegocios(){
		return repoNegocio.findAllByOrderByPuntuacionAsc();
	}
	
	public Negocio getNegocio(Long id) {
		return repoNegocio.findById(id).get();
	}
	
	public Iterable<Negocio> getNegociosByTipo(Long idTipo) {
		
		TipoNegocio tn=repoTipo.findById(idTipo).get();
		return repoNegocio.findAllByTipoNegocioOrderByPuntuacionAsc(tn);
	}
}
