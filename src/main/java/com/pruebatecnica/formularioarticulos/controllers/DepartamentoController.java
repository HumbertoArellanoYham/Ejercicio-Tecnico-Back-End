package com.pruebatecnica.formularioarticulos.controllers;

import com.pruebatecnica.formularioarticulos.entities.Departamento;
import com.pruebatecnica.formularioarticulos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping(value = "/departamentos-todos")
    public ResponseEntity<List<Departamento>> obtenerTodosLosDepartamentos(){
        List<Departamento> departamentoList = departamentoService.obtenerTodos();

        return new ResponseEntity<>(departamentoList, HttpStatus.OK);
    }

    @GetMapping(value = "/obtenerPorNum/{num}")
    public ResponseEntity<Departamento> buscarPorNum(@PathVariable(value = "num") Integer num){
        Optional<Departamento> optionalDepartamento = departamentoService.findById(num);

        return optionalDepartamento.map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/obtenerPorNombre/{nombre}")
    public ResponseEntity<Integer> buscarPorNombre(@PathVariable(value = "nombre") String nombre){
        Optional<Integer> optionalDepartamento = departamentoService.obtenerIdDelSelect(nombre);

        return optionalDepartamento.map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
