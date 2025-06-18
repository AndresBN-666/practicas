package org.example.gestionDePublicaciones.model;

import jakarta.persistence.*;
import org.example.gestionDePublicaciones.Imprimible;

import java.time.LocalDate;


public class Libro extends Publication implements Imprimible {
    private int numeroPaginas;




    public Libro(String titulo, String autor, LocalDate fechaPublicacion, Integer numeroPaginas) {
        super(titulo, autor, fechaPublicacion);
        this.numeroPaginas = numeroPaginas;
    }

    public Libro() {
    }


    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String tipo() {
        return "Libro";
    }

    @Override
    public void imprimir() {
        System.out.println(" Titulo: " + this.getTitulo() + " Autor: " + this.getAutor() + " Numero de Paginas: " + this.getNumeroPaginas()); ;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "numeroPaginas=" + numeroPaginas +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }
}
