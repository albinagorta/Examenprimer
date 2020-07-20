package com.app.examenprimer;

import java.io.Serializable;

public class Carrito implements Serializable {
    String nombre;
    String Talla;
    double precio;

    public Carrito() {
    }

    public Carrito(String nombre, String talla, double precio) {
        this.nombre = nombre;
        Talla = talla;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String talla) {
        Talla = talla;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
