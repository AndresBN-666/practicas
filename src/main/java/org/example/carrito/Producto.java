package org.example.carrito;

public class Producto {
    private String nombre;
    private Double precio;

    public Producto(String nombre, Double precio) {
        if (precio<0){
            throw new IllegalArgumentException("Precio no puede ser negativo");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
}
