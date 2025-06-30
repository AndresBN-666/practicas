package org.example.ejercicios;

import java.util.*;
import java.util.stream.Collectors;

public class MetodosStreams {

    // Sumar usuarios por ciudad dos formas

    public Map<String, Integer> sumaUsuariosPorCiudad(List<Usuario> usuarios) {
        Map<String, Integer> mapa = new HashMap<String, Integer>();
        for (Usuario usuario : usuarios) {
            String ciudad = usuario.getCiudad();
            mapa.merge(ciudad, 1, Integer::sum);
        }
        return mapa;
    }

    public Map<String, Integer> sumaUsuariosPorCiudadStream(List<Usuario> usuarios) {
        return usuarios.stream()
                .collect(Collectors.groupingBy(
                        Usuario::getCiudad,
                        //Collectors.counting() con long
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));
    }

    // Agrupar los nombres únicos de los usuarios por ciudad.

    public Map<String, Set<String>> agruparNombresUnicosPorCiudad(List<Usuario> usuarios) {
        Map<String, Set<String>> mapa = new HashMap<>();
        for (Usuario usuario : usuarios) {
            String ciudad = usuario.getCiudad();
            mapa
                    .computeIfAbsent(ciudad, k -> new HashSet<>())
                    .add( usuario.getNombre());
        }
        return mapa;
    }

    public Map<String, Set<String>> agruparNombresUnicosPorCiudadStream(List<Usuario> usuarios){
        return usuarios.stream()
                .collect(Collectors.groupingBy(
                        Usuario :: getCiudad,
                        Collectors.mapping(Usuario :: getNombre, Collectors.toSet()
                                )));
    }

    // Agrupar nombres únicos por ciudad y por rango de edad

    public Map<String, Map<String, Set<String>>> agruparPorCiudadYEdad(List<Usuario> usuarios) {
        Map<String, Map<String, Set<String>>> mapa = new HashMap<>();
        for (Usuario usuario : usuarios) {
            String ciudad = usuario.getCiudad();
            int edad = usuario.getEdad();

            String rango = null;
            if (edad<18){
                rango = "Menor";
            } else if ( edad < 60) {
                rango = "Adulto";
            } else {
                rango = "Mayor";
            }

            mapa.computeIfAbsent(ciudad, k -> new HashMap<>())
                    .computeIfAbsent(rango, k -> new HashSet<>())
                    .add(usuario.getNombre());
        }
        return mapa;
    }

    public Map<String, Map<String, Set<String>>> agruparPorCiudadYEdadMap(List<Usuario> usuarios){
        return usuarios.stream()
                .collect(Collectors.groupingBy(
                        Usuario :: getCiudad,
                        Collectors.groupingBy(
                                usuario -> {
                                    int edad = usuario.getEdad();
                                    if (edad<18) return "Menor";
                                    else if (edad<60) return "Adulto";
                                    else return "Mayor";
                                },
                                Collectors.mapping(
                                        Usuario::getNombre,
                                        Collectors.toSet()
                                )
                )));
    }

}
