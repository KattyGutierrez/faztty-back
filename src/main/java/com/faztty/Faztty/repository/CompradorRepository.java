package com.faztty.Faztty.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.faztty.Faztty.entity.Comprador;

@Repository
public interface CompradorRepository extends CrudRepository<Comprador, Long> {



}
