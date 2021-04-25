package com.faztty.Faztty.service;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faztty.Faztty.bean.UsuarioBean;
import com.faztty.Faztty.entity.Usuario;
import com.faztty.Faztty.repository.CompradorRepository;
import com.faztty.Faztty.repository.NegocioRepository;
import com.faztty.Faztty.repository.UsuarioRepository;



@Service
public class UsuarioService  {
	
	@Autowired
	UsuarioRepository repoUsuario;

	@Autowired
	NegocioRepository repoNego;
	
	
	@Autowired
	CompradorRepository repoCompra;
	
	public Usuario  getUsuario(Long id){
		return repoUsuario.findById(id).get();
	}

	public UsuarioBean autenticacion(UsuarioBean ub){
		Usuario u= repoUsuario.findByUsername(ub.getUsername());
		
		if(u!=null) {
			ub.setId(u.getId());
			if(ub.getPassword().equals("12345"))
				if(u.getPassword().equals("$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC")) 
					if(repoNego.findById(ub.getId()).isPresent()) {
						
						ub.setTipo("N");
					}
					else ub.setTipo("C");
			return ub;
		}
			
		return null;
			
	}


}
