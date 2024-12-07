package com.pruebatecnica.formularioarticulos.controllers;

import com.pruebatecnica.formularioarticulos.entities.Clase;
import com.pruebatecnica.formularioarticulos.entities.Departamento;
import com.pruebatecnica.formularioarticulos.services.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCheckpointRestore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clase")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @GetMapping(value = "/clase-todas")
    public ResponseEntity<List<Clase>> obtenerTodasLasClases(){
        List<Clase> claseList = claseService.obtenerTodos();

        return new ResponseEntity<>(claseList, HttpStatus.OK);
    }

    @GetMapping(value = "/obtenerPorNum/{num}")
    public ResponseEntity<Clase> buscarPorNum(@PathVariable(value = "num") Integer num){
        Optional<Clase> optionalClase = claseService.findById(num);

        return optionalClase.map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/obtenerPorNombre/{nombre}")
    public ResponseEntity<Integer> buscarPorNombre(@PathVariable(value = "nombre") String nombre){
        Optional<Integer> optionalClase = claseService.obtenerIdDelSelect(nombre);

        return optionalClase.map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
