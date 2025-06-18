package org.example.Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Libro> libros = new ArrayList<Libro>();
    private static LocalDate FECHACERO = LocalDate.of(0,10,1);

    public void agregarLibro(Libro libro) {
        if (libro.getAnioPublicacion().isBefore(FECHACERO)){
            System.out.println("no se puede agregar libros");
            return;
        }
        libros.add(libro);
    }

    public List<Libro> buscarPorAutor(String autor){
        /*        List<Libro> libros1 = new ArrayList<>();
        for (Libro libro : libros) {
            if(libro.getAutor().equals(autor)){
                libros1.add(libro);
            }
        }*/
        return libros.stream()
                .filter(libro -> libro.getAutor().equals(autor))
                .toList();
    }

    public void eliminarLibro(String nombre){
        boolean eliminado = libros
                .removeIf(libro -> libro.getTitulo().equalsIgnoreCase(nombre));
        if (!eliminado) {
            throw new IllegalArgumentException("No se puede eliminar el producto");
        }
    }

    public List<Libro> mostrarLibros(){
        return libros;
    }
}
