package com.faztty.Faztty.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.faztty.Faztty.entity.Negocio;
import com.faztty.Faztty.entity.TipoNegocio;

@Repository
public interface NegocioRepository extends CrudRepository<Negocio, Long>{

	Iterable<Negocio> findAllByOrderByPuntuacionAsc();



	Iterable<Negocio> findAllByTipoNegocioOrderByPuntuacionAsc(TipoNegocio tn);

}
