package com.pruebatecnica.formularioarticulos.repositories;

import com.pruebatecnica.formularioarticulos.entities.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo,Integer>{
}
