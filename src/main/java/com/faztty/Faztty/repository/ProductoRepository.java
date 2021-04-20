package com.faztty.Faztty.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faztty.Faztty.entity.Categoria;
import com.faztty.Faztty.entity.Negocio;
import com.faztty.Faztty.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

	Iterable<Producto> findAllByOrderByPuntuacionAsc();

	Iterable<Producto> findAllByCategoriaAndNegocioOrderByPuntuacionAsc(Categoria c,Negocio n);



	Iterable<Producto> findAllByNegocioOrderByPuntuacionAsc(Negocio n);

}
