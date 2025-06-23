package org.example.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrincipalEjercicios {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        List<String> palabras = Arrays.asList("Sol", "Silla", "Río", "Rana", "Perro", "Pez");
        List<Compra> compras = List.of(
                new Compra("pan",1.5),
                new Compra("leche",2.0),
                new Compra("pan", 1.2),
                new Compra("huevos", 3.0),
                new Compra("leche", 1.8)
        );
        List<Usuario> usuario = List.of(
                new Usuario("Ana", "Lima"),
                new Usuario("Luis",  "Arequipa"),
                new Usuario("Pedro",  "Lima"),
                new Usuario("Sofia", "Cusco"),
                new Usuario("Lucia",  "Cusco"),
                new Usuario("Diego",  "Arequipa")
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
                new Producto("Cama", "Dormitorio"),
                new Producto("Sabanas", "Dormitorio"),
                new Producto("Licuadora", "Cocina"),
                new Producto("ollas", "Cocina"),
                new Producto("Toalla", "Baño")
        );

        System.out.println(metodos.contarPalabrasTexto("hola mundo hola java mundo hola"));

    }
}
