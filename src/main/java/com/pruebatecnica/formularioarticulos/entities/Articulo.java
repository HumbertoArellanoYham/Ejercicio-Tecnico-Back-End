package com.pruebatecnica.formularioarticulos.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "articulos", schema = "public")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sku;

    @Column(length = 15, nullable = false)
    private String articulo;

    @Column(length = 15, nullable = false)
    private String marca;

    @Column(length = 20, nullable = false )
    private String modelo;

    @Column(nullable = false)
    private Integer departamento;

    @Column(nullable = false)
    private Integer clase;

    @Column(nullable = false)
    private Integer familia;

    @Column(name = "fecha_alta", nullable = false)
    private LocalDate fechaAlta;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Byte descontinuado;

    @Column(name = "fecha_baja", nullable = false)
    private LocalDate fechaBaja;

    public Articulo() {
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Byte getDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(Byte descontinuado) {
        this.descontinuado = descontinuado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Integer getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }

    public Integer getFamilia() {
        return familia;
    }

    public void setFamilia(Integer familia) {
        this.familia = familia;
    }

    public Integer getClase() {
        return clase;
    }

    public void setClase(Integer clase) {
        this.clase = clase;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "sku=" + sku +
                ", articulo='" + articulo + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", departamento=" + departamento +
                ", clase=" + clase +
                ", familia=" + familia +
                ", fechaAlta=" + fechaAlta +
                ", stock=" + stock +
                ", cantidad=" + cantidad +
                ", descontinuado=" + descontinuado +
                ", fechaBaja=" + fechaBaja +
                '}';
    }
}
