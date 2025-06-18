package org.example.gestionDePublicaciones.model;

import org.example.gestionDePublicaciones.Imprimible;

import java.time.LocalDate;

public class ArticuloAcademico extends Publication implements Imprimible {
    @Override
    public void imprimir() {
        System.out.println("IA Moderna " + this.getTitulo() + " Autor: " + this.getAutor() +
                " Universidad " + universidad + " Revisado " + revisadoPorPares);
    }

    private String universidad;
    private boolean revisadoPorPares;

    public ArticuloAcademico(String titulo, String autor, LocalDate fechaPublicacion, String universidad, boolean revisadoPorPares) {
        super(titulo, autor, fechaPublicacion);
        this.universidad = universidad;
        this.revisadoPorPares = revisadoPorPares;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public boolean isRevisadoPorPares() {
        return revisadoPorPares;
    }

    public void setRevisadoPorPares(boolean revisadoPorPares) {
        this.revisadoPorPares = revisadoPorPares;
    }

    @Override
    public String tipo() {
        return "Artículo Académico";
    }
}
