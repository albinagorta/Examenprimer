package com.app.examenprimer;

import java.io.Serializable;

public class Prendas implements Serializable {
    int código;
    String nombre;
    int imagen;
    String talla;
    double precios;
    int cantidad;
    int stock;

    public Prendas() {
    }

    public Prendas(int código, String nombre, String talla, double precios, int cantidad, int stock) {
        this.código = código;
        this.nombre = nombre;
        this.talla = talla;
        this.precios = precios;
        this.cantidad = cantidad;
        this.stock = stock;
    }

    public Prendas(int código, String nombre, int imagen, String talla, double precios, int cantidad, int stock) {
        this.código = código;
        this.nombre = nombre;
        this.imagen = imagen;
        this.talla = talla;
        this.precios = precios;
        this.cantidad = cantidad;
        this.stock = stock;
    }

    public int getCódigo() {
        return código;
    }

    public void setCódigo(int código) {
        this.código = código;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public double getPrecios() {
        return precios;
    }

    public void setPrecios(double precios) {
        this.precios = precios;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
