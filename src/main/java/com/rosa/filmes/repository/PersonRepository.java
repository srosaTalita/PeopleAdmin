package com.rosa.filmes.repository;

import com.rosa.filmes.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer>{
    
}
