package org.example.clases;

public class Auto {
    private String marca;
    private String modelo;
    private Integer anio;

    public Auto(String marca, String modelo, Integer anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }
    public void mostrarInfo(){
        System.out.println("Marca: " + marca + " Modelo: " + modelo + " Año: " + anio);
    }
}
