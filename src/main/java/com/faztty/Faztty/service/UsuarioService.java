package com.faztty.Faztty.service;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faztty.Faztty.entity.Usuario;
import com.faztty.Faztty.repository.UsuarioRepository;



@Service
public class UsuarioService  {
	
	@Autowired
	UsuarioRepository repoUsuario;


	
	public Usuario  getUsuario(Long id){
		return repoUsuario.findById(id).get();
	}

	public Usuario autenticacion(String username, String pass){
		Usuario u= repoUsuario.findByUsername(username);
		if(u!=null)
			if(pass.equals("12345"))
				if(u.getPassword().equals("$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC")) 
					return u;
		return null;
			
	}


}
