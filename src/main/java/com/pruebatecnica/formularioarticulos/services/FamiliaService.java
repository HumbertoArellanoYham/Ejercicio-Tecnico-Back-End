package com.pruebatecnica.formularioarticulos.services;

import com.pruebatecnica.formularioarticulos.entities.Familia;
import com.pruebatecnica.formularioarticulos.repositories.FamiliaRepository;
import com.pruebatecnica.formularioarticulos.services.interfaces.DataOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FamiliaService implements DataOperations<Familia> {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Familia> findById(Integer id) {
        return familiaRepository.findById(id);
    }

    @Override
    public Optional<Familia> guardar(Familia familia) {
        return Optional.empty();
    }

    @Override
    public Optional<Familia> actualizarOptional(Familia familia) {
        return Optional.empty();
    }

    @Override
    public Optional<Familia> removeById(Integer id) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Integer> obtenerIdDelSelect(String familiaNombre) {
        return familiaRepository.getFamiliaIdByName(familiaNombre);
    }

    @Override
    public Optional<Familia> removeByEntity(Familia familia) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Familia> obtenerTodos() {
        return familiaRepository.findAll();
    }
}
