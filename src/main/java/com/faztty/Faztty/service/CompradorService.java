package com.faztty.Faztty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faztty.Faztty.entity.Comprador;
import com.faztty.Faztty.repository.CompradorRepository;

@Service
public class CompradorService {
	@Autowired
	CompradorRepository repoComprador;
	
	public Comprador getComprador(Long id) {
		return repoComprador.findById(id).get();
	}
	
}
