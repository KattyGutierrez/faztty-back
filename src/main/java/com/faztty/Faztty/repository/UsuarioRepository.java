package com.faztty.Faztty.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faztty.Faztty.entity.Negocio;

@Repository
public interface UsuarioRepository extends CrudRepository<Negocio, Long> {

}
