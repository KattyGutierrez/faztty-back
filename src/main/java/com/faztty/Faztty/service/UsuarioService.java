package com.faztty.Faztty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faztty.Faztty.entity.Negocio;

import com.faztty.Faztty.repository.UsuarioRepository;



@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repoUsuario;
	public Iterable<Negocio> getUsuarios(){
		return repoUsuario.findAll();
	}
	
	public Negocio getNegocio(Long id) {
		return repoUsuario.findById(id).get();
	}
}
