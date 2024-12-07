package com.pruebatecnica.formularioarticulos.services;

import com.pruebatecnica.formularioarticulos.entities.Articulo;
import com.pruebatecnica.formularioarticulos.repositories.ArticuloRepository;
import com.pruebatecnica.formularioarticulos.services.interfaces.DataOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService implements DataOperations<Articulo> {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Articulo> findById(Integer num) {
        return articuloRepository.findById(num);
    }

    @Transactional
    @Override
    public Optional<Articulo> guardar(Articulo articulo) {
        return Optional.of(articuloRepository.save(articulo));
    }

    @Transactional
    @Override
    public Optional<Articulo> actualizarOptional(Articulo articulo) {
        return Optional.of(articuloRepository.save(articulo));
    }

    @Transactional
    @Override
    public Optional<Articulo> removeById(Integer num) {
        articuloRepository.deleteById(num);

        return articuloRepository.findById(num);
    }

    @Override
    public Optional<Integer> obtenerIdDelSelect(String any) {
        return Optional.empty();
    }

    @Override
    public Optional<Articulo> removeByEntity(Articulo articulo) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Articulo> obtenerTodos() {
        return articuloRepository.findAll();
    }
}
