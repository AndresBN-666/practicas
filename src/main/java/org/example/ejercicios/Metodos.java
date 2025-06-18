package org.example.ejercicios;

import java.util.*;

public class Metodos {

    /**
     * Metodo que suma numeros impares
     * @param array coleccion de numeros de loc cuales solo se suma los impares
     * @return suma de numero impares
     */
    public int sumarImpares(int[] array){
        int suma = 0;
        for (int num : array){
            if(num % 2 != 0){
                suma += num;
            }
        }
        return suma;
    }

    // Ejercicio clasico de FizzBuzz
    public List<String>fizzBuzz(){
        List<String> resultado = new ArrayList<>();

        for (int i = 1; i <=100 ; i++){
            if(i% 3 == 0 && i % 5 == 0){
                resultado.add("FizzBuzz");
            } else if (i % 3 == 0) {
                resultado.add("Fizz");
            } else if (i % 5 == 0) {
                resultado.add("Buzz");
            } else {
                resultado.add(String.valueOf(i));
            }
        }
        return resultado;
    }

    // metodo que busca el primer caracter no repetido
    public char primerNoRepetido(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : input.toCharArray()){
            if(map.get(c) == 1){
                return c;
            }
        }
        return '-';
    }

    // Metodo para contar palabras de un String
    public Map<String, Integer> contarPalabras(String input){
        Map<String, Integer> map = new HashMap<>();
        String[] palabras = input.split(" ");
        for (String palabra : palabras){
            map.put(palabra, map.getOrDefault(palabra, 0) + 1);
        }
        /*for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/
       return map;
    }

    // Metodo para agrupar por longitud con computeifAbsent
    public  Map<Integer, List<String>> agruparPorLongitud(List<String> lista){
        Map<Integer, List<String>> map = new HashMap<>();
        for (String palabra : lista){
            int longitud = palabra.length();
            map.computeIfAbsent(longitud, k -> new ArrayList<>()).add(palabra);
        }
        return map;
    }

    // Metodo para agrupar por longitud con constainskey
    public Map<Integer, List<String>> agruparPorLongitud2(List<String> lista){
        Map<Integer, List<String>> map = new HashMap<>();
        for (String palabra : lista){
            int longitud = palabra.length();

            if (!map.containsKey(longitud)) {
                map.put(longitud, new ArrayList<>()); // si no existe, agregamos una nueva lista
            }

            map.get(longitud).add(palabra); // ahora sí agregamos la palabra a la lista
        
        }
        return map;
    }

}
