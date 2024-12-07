package com.pruebatecnica.formularioarticulos.repositories;

import com.pruebatecnica.formularioarticulos.entities.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Integer> {
    @Query("SELECT public.get_familia_id_by_name(:nombre) ")
    Optional<Integer> getFamiliaIdByName(@Param("nombre") String nombre);
}
