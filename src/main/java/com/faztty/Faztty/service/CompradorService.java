package com.faztty.Faztty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faztty.Faztty.bean.CompradorBean;
import com.faztty.Faztty.entity.Comprador;
import com.faztty.Faztty.repository.CompradorRepository;

@Service
public class CompradorService {
	@Autowired
	CompradorRepository repoComprador;
	

	public Comprador getComprador(Long id) {
		return repoComprador.findById(id).get();
	}
	public Comprador registrar(CompradorBean cb) {
			Comprador c= new Comprador();
			
			c.setUsername(cb.getUsername());
			c.setEmail(cb.getEmail());
			
			c.setPassword("$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC");
			//c.setPassword((cb.getContra()));
			c.setDni(cb.getDni());
			c.setFirstName(cb.getFirstname());
			c.setLastName(cb.getLastname());
			repoComprador.save(c);
			return c;
	}
}
