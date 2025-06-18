package org.example.gestionDePublicaciones.model;

import org.example.gestionDePublicaciones.Imprimible;

import java.time.LocalDate;

public class Tesis extends Publication implements Imprimible {

    private String grado;
    private String asesor;

    public Tesis(String titulo, String autor, LocalDate fechaPublicacion, String grado, String asesor) {
        super(titulo, autor, fechaPublicacion);
        this.grado = grado;
        this.asesor = asesor;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    @Override
    public String tipo() {
        return "Tesis";
    }

    @Override
    public void imprimir() {
        System.out.println("Titulo: " + getTitulo() + " Autor: " + getAutor()
        + " Fecha de publicacion: " + getFechaPublicacion() + " Grado: " + getGrado()
        + " Asesor: " + getAsesor());

    }
}
