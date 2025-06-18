package org.example.gestionDePublicaciones.model;

import jakarta.persistence.*;
import org.example.gestionDePublicaciones.Imprimible;

import java.time.LocalDate;


public abstract class Publication implements Comparable<Publication>, Imprimible {

    private Long id;

    protected String titulo;
    protected String autor;
    protected LocalDate fechaPublicacion;

    public Publication() {

    }

    @Override
    public int compareTo(Publication o) {
        return this.fechaPublicacion.compareTo(o.fechaPublicacion);
    }

    public Publication(String titulo, String autor, LocalDate fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public abstract String tipo();

    public boolean esReciente(){
        return fechaPublicacion.isAfter(LocalDate.now().minusDays(5));
    }

    @Override
    public String toString() {
        return "Publication{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
}
