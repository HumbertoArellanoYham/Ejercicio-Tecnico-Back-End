package com.pruebatecnica.formularioarticulos.services;

import com.pruebatecnica.formularioarticulos.entities.Clase;
import com.pruebatecnica.formularioarticulos.repositories.ClaseRepository;
import com.pruebatecnica.formularioarticulos.services.interfaces.DataOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseService implements DataOperations<Clase> {

    @Autowired
    private ClaseRepository claseRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Clase> findById(Integer num) {
        return claseRepository.findById(num);
    }

    @Override
    public Optional<Clase> guardar(Clase clase) {
        return Optional.empty();
    }

    @Override
    public Optional<Clase> actualizarOptional(Clase clase) {
        return Optional.empty();
    }

    @Override
    public Optional<Clase> removeById(Integer num) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Integer> obtenerIdDelSelect(String clase) {
        return claseRepository.getClaseIdByName(clase);
    }

    @Override
    public Optional<Clase> removeByEntity(Clase clase) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Clase> obtenerTodos() {
        return claseRepository.findAll();
    }
}
