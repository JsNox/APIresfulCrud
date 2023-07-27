package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.alumnoModel;
import com.example.demo.respositories.alumnoRepository;

@Service
public class alumnoService {

    @Autowired
    alumnoRepository alumnoRepository;
    
    public alumnoModel guardarAlumno(alumnoModel alumno){
        return alumnoRepository.save(alumno);
    }
    //bucar alumno
    public ArrayList<alumnoModel> obtenerAlumno(){
        return (ArrayList<alumnoModel>) alumnoRepository.findAll();
    }

    public Optional <alumnoModel> obtenerMatricula(Integer matricula){
        return alumnoRepository.findById(matricula);
    }

    public boolean eliminarAlumno(Integer matricula){
        try {
            alumnoRepository.deleteById(matricula);
            return true;
        
        } catch (Exception e) {
            return false;
        }
    }


    
}
