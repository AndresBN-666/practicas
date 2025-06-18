package org.example.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrincipalEjercicios {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        List<String> palabras = Arrays.asList("Casa", "cielo", "Sol", "sombra", "perro", "Pan");
        List<Compra> compras = List.of(
                new Compra("pan",1.5),
                new Compra("leche",2.0),
                new Compra("pan", 1.2),
                new Compra("huevos", 3.0),
                new Compra("leche", 1.8)
        );

        System.out.println(metodos.calcularMontoPorProductos(compras));

    }
}
