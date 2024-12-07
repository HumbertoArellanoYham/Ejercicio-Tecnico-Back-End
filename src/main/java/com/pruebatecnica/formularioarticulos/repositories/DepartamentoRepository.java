package com.pruebatecnica.formularioarticulos.repositories;

import com.pruebatecnica.formularioarticulos.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    @Query("SELECT public.get_departamento_id_by_name(:nombre) ")
    Optional<Integer> getDepartamentoIdByName(@Param("nombre") String nombre);
}
