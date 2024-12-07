package com.pruebatecnica.formularioarticulos.controllers;

import com.pruebatecnica.formularioarticulos.entities.Clase;
import com.pruebatecnica.formularioarticulos.entities.Familia;
import com.pruebatecnica.formularioarticulos.services.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/familia")
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @GetMapping(value = "/familia-todas")
    public ResponseEntity<List<Familia>> obtenerTodasLasFamilias(){
        List<Familia> familiaList = familiaService.obtenerTodos();

        return new ResponseEntity<>(familiaList, HttpStatus.OK);
    }

    @GetMapping(value = "/obtenerPorNum/{num}")
    public ResponseEntity<Familia> buscarPorNum(@PathVariable(value = "num") Integer num){
        Optional<Familia> optionalFamilia = familiaService.findById(num);

        return optionalFamilia.map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/obtenerPorNombre/{nombre}")
    public ResponseEntity<Integer> buscarPorNombre(@PathVariable(value = "nombre") String nombre){
        Optional<Integer> optionalFamilia = familiaService.obtenerIdDelSelect(nombre);

        return optionalFamilia.map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
