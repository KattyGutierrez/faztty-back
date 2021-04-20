package com.faztty.Faztty.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.faztty.Faztty.entity.Categoria;


@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

	Iterable<Categoria> findAllByOrderByIdAsc();

}
