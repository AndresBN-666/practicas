package org.example.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrincipalEjercicios {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();

        List<Compra> compras = List.of(
                new Compra("pan",1.5),
                new Compra("leche",2.0),
                new Compra("pan", 1.2),
                new Compra("huevos", 3.0),
                new Compra("leche", 1.8)
        );
        List<Usuario> usuario = List.of(
                new Usuario("Ana", "Lima", 25),
                new Usuario("Luis", "Lima", 30),
                new Usuario("Ana", "Lima", 40),
                new Usuario("Carmen", "Arequipa", 50),
                new Usuario("Pedro", "Lima", 35),
                new Usuario("Carmen", "Arequipa", 60)
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
                new Producto("Sábana", "Hogar", 80.0),         // 👈 duplicado global: NO se agrega
                new Producto("Colcha", "Dormitorio", 30.0),    // precio < 40: NO se agrega
                new Producto("Almohada", "Dormitorio", 55.0),
                new Producto("Escritorio", "Oficina", 120.0),
                new Producto("Silla", "Oficina", 90.0),
                new Producto("Silla", "Casa", 95.0),           // 👈 duplicado global: NO se agrega
                new Producto("Funda", "Dormitorio", 25.0)      // precio < 40: NO se agrega
        );
        List<String> palabras = List.of(
                "java", "html", "css", "spring", "java", "html", "c", "go", "springboot"
        );

        System.out.println(metodos.agruparProductosUnicosPorTipo(producto));

    }
}
