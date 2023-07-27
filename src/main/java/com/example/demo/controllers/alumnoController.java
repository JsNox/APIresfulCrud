package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.alumnoModel;
import com.example.demo.services.alumnoService;

@RestController
@RequestMapping
public class alumnoController {
    @Autowired
    alumnoService alumnoService;

    @GetMapping("/todo")
    public ArrayList<alumnoModel> obtenerAlumnoModels(){
        return alumnoService.obtenerAlumno();
    }

    @PostMapping("/guardar")
    public alumnoModel guardarAlumnoModel (@RequestBody alumnoModel alumno){
        return this.alumnoService.guardarAlumno(alumno);
    }

    @GetMapping( path = "/{matricula}")
    public Optional<alumnoModel> obtenerAlumnoporMatricula(@PathVariable("matricula") Integer matricula){
        return this.alumnoService.obtenerMatricula(matricula);
    }
    @DeleteMapping( path = "/{matricula}")
    public String eliminarAlumno(@PathVariable("matricula") Integer matricula){
        boolean ok = this.alumnoService.eliminarAlumno(matricula);
        if(ok){
            return "El alumno fue eliminado con exito" + matricula;
        }
        else{
            return "No se pudo eliminar el alumno" + matricula;
        }
    }
    
}
