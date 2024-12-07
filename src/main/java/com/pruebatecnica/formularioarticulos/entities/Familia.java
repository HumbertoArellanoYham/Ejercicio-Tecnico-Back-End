package com.pruebatecnica.formularioarticulos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "familia", schema = "public")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_familia")
    private Integer idFamilia;

    @Column(name = "nombre_familia", nullable = false)
    private String nombreFamilia;

    public Familia() {
    }

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    @Override
    public String toString() {
        return "Familia{" +
                "idFamilia=" + idFamilia +
                ", nombreFamilia='" + nombreFamilia + '\'' +
                '}';
    }
}
