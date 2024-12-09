package com.pruebatecnica.formularioarticulos.controllers;

import com.pruebatecnica.formularioarticulos.entities.Articulo;
import com.pruebatecnica.formularioarticulos.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping(value = "/obtenerPorSku/{sku}")
    public ResponseEntity<Articulo> buscarArticuloPorSku(@PathVariable(value = "sku") Integer sku){
        Optional<Articulo> isFound = articuloService.findById(sku);

        return isFound.map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> null);
    }

    @GetMapping(value = "/obtenerTodosLosArticulos")
    public ResponseEntity<List<Articulo>> todosLosArticulos(){
        return new ResponseEntity<>(articuloService.obtenerTodos(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminarPorSku/{sku}")
    public ResponseEntity<Boolean> removePorSku(@PathVariable(value = "sku") Integer sku){
        Optional<Articulo> removed =  articuloService.findById(sku);

        if(removed.isEmpty()){
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }

        return articuloService.removeById(sku).map(item -> new ResponseEntity<>(false, HttpStatus.BAD_REQUEST))
                .orElseGet(() -> new ResponseEntity<>(true, HttpStatus.OK));
    }

    @PostMapping(value = "/guardarArticulo")
    public ResponseEntity<Articulo> saveArticulo(@RequestBody Articulo articulo){
        Optional<Articulo> isSave = articuloService.guardar(articulo);

        return isSave.map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PatchMapping(value = "/actualizarArticulo")
    public ResponseEntity<Articulo> updateArticulo(@RequestBody Articulo articulo){
        Optional<Articulo> isUpdated = articuloService.actualizarOptional(articulo);

        return isUpdated.map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
