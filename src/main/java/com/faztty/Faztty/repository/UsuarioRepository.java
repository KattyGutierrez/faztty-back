package com.faztty.Faztty.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faztty.Faztty.entity.Negocio;
import com.faztty.Faztty.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByUsername(String username);
		
}
