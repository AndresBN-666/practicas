package org.example.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrincipalEjercicios {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();

        List<Compra> compras = List.of(
                new Compra("Lima", "Electrónica", 200.0),
                new Compra("Lima", "Electrónica", 300.0),
                new Compra("Lima", "Ropa", 150.0),
                new Compra("Arequipa", "Ropa", 100.0),
                new Compra("Arequipa", "Electrónica", 50.0),
                new Compra("Lima", "Ropa", 100.0)
        );
        List<Usuario> usuario = List.of(
                new Usuario("Ana", "Lima", 15),
                new Usuario("Luis", "Lima", 25),
                new Usuario("Pedro", "Lima", 65),
                new Usuario("Sofia", "Arequipa", 12),
                new Usuario("Carmen", "Arequipa", 70),
                new Usuario("Leo", "Lima", 30),
                new Usuario("Mario", "Lima", 12)
        );

        List<Estudiante> estudiante = List.of(
                new Estudiante("Ana", "Java"),
                new Estudiante("Luis", "Spring"),
                new Estudiante("Ana", "Spring"),
                new Estudiante("Luis", "Spring"),
                new Estudiante("Pedro", "Java"),
                new Estudiante("Ana", "Java")
        );

        List<Producto> producto = List.of(
                new Producto("Sábana", "Dormitorio", 60.0),
                new Producto("Colcha", "Dormitorio", 40.0),   // ❌ no cuenta
                new Producto("Funda", "Dormitorio", 55.0),
                new Producto("Escritorio", "Oficina", 120.0),
                new Producto("Silla", "Oficina", 49.9),       // ❌ no cuenta
                new Producto("Lámpara", "Oficina", 70.0)
        );

        List<String> palabras = List.of(
                "java", "html", "css", "spring", "java", "html", "c", "go", "springboot"
        );

        System.out.println(metodos.calcularGastoPorCiudadYCategoria(compras));

    }
}
