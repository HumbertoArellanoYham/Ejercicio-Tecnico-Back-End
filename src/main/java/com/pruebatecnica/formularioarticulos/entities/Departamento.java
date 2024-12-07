package com.pruebatecnica.formularioarticulos.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departamento", schema = "public")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Integer idDepartamento;

    @Column(name = "nombre_departamento", nullable = false)
    private String nombreDepartamento;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "departamento_id", referencedColumnName = "id_departamento")
    private List<Clase> claseSet = new ArrayList<>();

    public Departamento() {
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public List<Clase> getClaseSet() {
        return claseSet;
    }

    public void setClaseSet(List<Clase> claseSet) {
        this.claseSet = claseSet;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento=" + idDepartamento +
                ", nombreDepartamento='" + nombreDepartamento + '\'' +
                '}';
    }
}
