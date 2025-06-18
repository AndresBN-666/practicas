package org.example.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrincipalEjercicios {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        List<String> palabras = Arrays.asList("hola", "adiós", "sol", "luz", "día", "mañana");

        System.out.println(metodos.agruparPorLongitud2(palabras));

    }
}
