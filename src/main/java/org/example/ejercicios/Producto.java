package org.example.ejercicios;

public class Producto {
    private String nombre;
    private String tipo;
    private double precio;
    private String ciudad;

    public Producto(String nombre, String tipo, double precio, String ciudad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.ciudad = ciudad;
    }

    public Producto(String nombre, String tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Producto(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
