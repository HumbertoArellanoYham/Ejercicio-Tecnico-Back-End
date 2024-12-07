package com.pruebatecnica.formularioarticulos.services;

import com.pruebatecnica.formularioarticulos.entities.Departamento;
import com.pruebatecnica.formularioarticulos.repositories.DepartamentoRepository;
import com.pruebatecnica.formularioarticulos.services.interfaces.DataOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements DataOperations<Departamento> {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Departamento> findById(Integer num) {
        return departamentoRepository.findById(num);
    }

    @Override
    public Optional<Departamento> guardar(Departamento departamento) {
        return Optional.empty();
    }

    @Override
    public Optional<Departamento> actualizarOptional(Departamento departamento) {
        return Optional.empty();
    }

    @Override
    public Optional<Departamento> removeById(Integer num) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Integer> obtenerIdDelSelect(String departamentoNombre) {
        return departamentoRepository.getDepartamentoIdByName(departamentoNombre);
    }

    @Override
    public Optional<Departamento> removeByEntity(Departamento departamento) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Departamento> obtenerTodos() {
        return departamentoRepository.findAll();
    }
}
