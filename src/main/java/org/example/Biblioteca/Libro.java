package org.example.Biblioteca;

import java.time.LocalDate;
import java.util.Date;

public class Libro {
    private String titulo;
    private String autor;
    private LocalDate anioPublicacion;

    public Libro(String titulo, String autor, LocalDate anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public void mostrarInfo(){
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Anio Publicacion: " + this.anioPublicacion);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getAnioPublicacion() {
        return anioPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion='" + anioPublicacion + '\'' +
                '}';
    }
}
