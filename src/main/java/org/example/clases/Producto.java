package org.example.clases;

public class Producto {
    private String nombre;
    private Double precio;
    private Double descuento;

    public Producto(String nombre, Double precio, Double descuento) {
        this.nombre = nombre;
        this.precio = precio;
        this.descuento = descuento;
    }

    public Double calcularPrecioFinal() {
        return precio - (precio * descuento / 100);
    }

    public void mostrarInfo(){
        System.out.println("Nombre: " + nombre + "\nPrecio: " + precio + "\nDescuento: " + descuento
         + "\nPrecio Final: " + calcularPrecioFinal());
    }
}
