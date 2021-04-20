package com.faztty.Faztty.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faztty.Faztty.entity.TipoNegocio;

@Repository
public interface TipoNegocioRepository  extends CrudRepository<TipoNegocio, Long>{

}
