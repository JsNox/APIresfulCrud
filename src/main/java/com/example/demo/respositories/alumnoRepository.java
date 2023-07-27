package com.example.demo.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.alumnoModel;

@Repository
public interface alumnoRepository extends CrudRepository<alumnoModel, Integer>{
    
}
