package org.example.ejercicios;

public class Compra{
    String nombre;
    Double precio;
    private String ciudad;
    private  String categoria;
    private double monto;

    public Compra(String ciudad, String categoria, double monto) {
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.monto = monto;
    }

    public Compra(String nombre, Double precio) {
         this.nombre = nombre;
         this.precio = precio;
     }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNombre() {
         return nombre;
     }

     public void setNombre(String nombre) {
         this.nombre = nombre;
     }

     public Double getPrecio() {
         return precio;
     }

     public void setPrecio(Double precio) {
         this.precio = precio;
     }
 }
