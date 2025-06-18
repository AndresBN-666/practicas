package org.example.herencia;

public class Libro {
    private String titulo;
    private String autor;
    private Double precio;

    public Libro(String titulo, String autor, Double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public void mostrarInfo(){
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Precio: " + this.precio);
    }

    public void aplicarDescuento(int descuento){
        if (descuento < 0 || descuento > 100){
            System.out.println("Descuento invalido");
            return;
        }
        precio = precio - (precio * descuento / 100);

        if (precio < 0){
            precio = 0.0;
        }

    }

    public Double getPrecio() {
        return precio;
    }
}
