package com.faztty.Faztty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faztty.Faztty.bean.NegocioBean;
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
	
	public Negocio registrar(NegocioBean nb) {
			Negocio n= new Negocio();
			
			n.setUsername(nb.getUsername());
			n.setEmail(nb.getEmail());
			n.setPassword("$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC");
			//n.setPassword((nb.getContra()));
			n.setDireccion(nb.getDireccion());
			n.setImagen(nb.getImagen());
			n.setNombre(nb.getNombre());
			n.setTipoNegocio(repoTipo.findById(nb.getTn()).get());
			n.setRUC(nb.getRuc());
			n.setPuntuacion((long)50);
			repoNegocio.save(n);
			return n;
	}
}
