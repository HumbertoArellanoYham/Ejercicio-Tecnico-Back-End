package com.pruebatecnica.formularioarticulos.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clase", schema = "public")
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private Integer idClase;

    @Column(name = "nombre_clase", nullable = false)
    private String nombreClase;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "clase_id", referencedColumnName = "id_clase")
    private List<Familia> familiaSet = new ArrayList<>();

    public Clase() {
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public List<Familia> getFamiliaSet() {
        return familiaSet;
    }

    public void setFamiliaSet(List<Familia> familiaSet) {
        this.familiaSet = familiaSet;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "nombreClase='" + nombreClase + '\'' +
                ", idClase=" + idClase +
                '}';
    }
}
