package com.pruebatecnica.formularioarticulos.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface DataOperations<T> {
    Optional<T> findById(Integer num);

    Optional<T> guardar(T t);

    Optional<T> actualizarOptional(T t);

    Optional<T>  removeById(Integer num);

    Optional<Integer> obtenerIdDelSelect(String any);

    Optional<T>  removeByEntity(T t);

    List<T> obtenerTodos();
}
