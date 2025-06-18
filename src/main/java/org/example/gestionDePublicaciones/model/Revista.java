package org.example.gestionDePublicaciones.model;

import org.example.gestionDePublicaciones.Imprimible;

import java.time.LocalDate;

public class Revista extends Publication implements Imprimible {
    private int numero;
    private String editorial;

    public Revista(String titulo, String autor, LocalDate fechaPublicacion, int numero, String editorial) {
        super(titulo, autor, fechaPublicacion);
        this.numero = numero;
        this.editorial = editorial;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String tipo() {
        return "Revista";
    }

    @Override
    public void imprimir() {
        System.out.println("Titulo: " + getTitulo() + " Autor: " + getAutor() +
                "Fecha: " + getFechaPublicacion() + " Numero: " + getNumero() + " Editorial: " + getEditorial());
    }

    @Override
    public String toString() {
        return "Revista{" +
                "numero=" + numero +
                ", editorial='" + editorial + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }
}
