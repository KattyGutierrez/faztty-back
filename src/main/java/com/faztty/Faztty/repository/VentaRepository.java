package com.faztty.Faztty.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faztty.Faztty.entity.Venta;


@Repository
public interface VentaRepository extends CrudRepository<Venta, Long> {

}
