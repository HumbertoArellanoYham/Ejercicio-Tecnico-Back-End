package com.pruebatecnica.formularioarticulos.repositories;

import com.pruebatecnica.formularioarticulos.entities.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Integer> {
    @Query("SELECT public.get_clase_id_by_name(:nombre) ")
    Optional<Integer> getClaseIdByName(@Param("nombre") String nombre);
}
