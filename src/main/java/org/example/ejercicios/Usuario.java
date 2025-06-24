package org.example.ejercicios;

public class Usuario {
    private String nombre;
    private String ciudad;
    private int edad;

    public Usuario(String nombre, String ciudad, int edad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    public Usuario(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
