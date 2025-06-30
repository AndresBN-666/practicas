package org.example.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrincipalEjercicios {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        MetodosStreams metodosStreams = new MetodosStreams();

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
                new Usuario("Luis", "Lima", 30),
                new Usuario("Pedro", "Lima", 65),
                new Usuario("Pedro", "Cusco", 65),
                new Usuario("Lucia", "Cusco", 12),
                new Usuario("Jorge", "Arequipa", 22)
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
                new Producto("Laptop", "Electrónica", 1200.0, "Lima"),
                new Producto("Smartphone", "Electrónica", 800.0, "Lima"),
                new Producto("Mesa", "Muebles", 150.0, "Lima"),
                new Producto("Silla", "Muebles", 150.0, "Lima"),
                new Producto("Mesa", "Muebles", 200.0, "Lima"), // Duplicado, no debe contarse dos veces
                new Producto("Laptop", "Electrónica", 1100.0, "Arequipa"),
                new Producto("Smartphone", "Electrónica", 900.0, "Arequipa"),
                new Producto("Silla", "Muebles", 180.0, "Arequipa")
        );

        List<String> palabras = List.of(
                "java", "html", "css", "spring", "java", "html", "c", "go", "springboot"
        );

        System.out.println(metodosStreams.agruparPorCiudadYEdadMap(usuario));

    }
}
