package com.rosa.filmes.repository;

import com.rosa.filmes.model.Phone;
import org.springframework.data.repository.CrudRepository;

public interface TipoClienteRepository extends CrudRepository<Phone, Integer>{
    
}
