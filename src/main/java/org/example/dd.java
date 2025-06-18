package org.example;

import org.example.exception.PublicacionDuplicadaException;
import org.example.gestionDePublicaciones.Repository.InMemoryPublicationRepository;
import org.example.gestionDePublicaciones.Repository.JdbcPublicationRepository;
import org.example.gestionDePublicaciones.Repository.PublicationRepository;
import org.example.gestionDePublicaciones.controller.BibliotecaController;
import org.example.gestionDePublicaciones.model.Biblioteca;
import org.example.gestionDePublicaciones.model.Libro;
import org.example.gestionDePublicaciones.model.Publication;
import org.example.gestionDePublicaciones.model.Revista;
import org.example.gestionDePublicaciones.service.BibliotecaService;

import java.time.LocalDate;
import java.util.*;

public class dd {

    public static void main(String[] args) {
        PublicationRepository repository = new JdbcPublicationRepository();
        BibliotecaService service = new BibliotecaService(repository);

        /*service.agregar(new Libro("1984", "Orwell", LocalDate.of(1949, 6, 8), 328));
        service.agregar(new Revista("Ciencia Hoy", "Varios", LocalDate.of(2023, 1, 1), 45, "Ciencia Editorial"));

        System.out.println("¡Publicaciones guardadas en la base de datos!");
        System.out.println(service.obtenerTodas());*/

        List<Publication> publicaciones = service.obtenerTodas();
        for (Publication p : publicaciones) {
            System.out.println(p);
        }

        System.out.println("suma de enteros");
        int[] array = {1,2,3,4};
        sumarEntero(array);

        fizzBuzz();

        System.out.println(esPalindromo(12235));

    }

    static boolean esPalindromo(int numero) {
        // tu lógica aquí
        String original = String.valueOf(numero); // Convertimos el número a String
        String invertida = new StringBuilder(original).reverse().toString(); // Invertimos la cadena
        return original.equals(invertida);
    }

    static void sumarEntero(int[] array){
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        System.out.println(sum);

    }

    static void fizzBuzz() {
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }






        /*Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarPublication(new Libro("1984", "Orwell", LocalDate.of(1949, 6, 8), 100));
        biblioteca.agregarPublication(new Libro("1982", "Orwell", LocalDate.of(1949, 6, 8), 100));
        biblioteca.agregarPublication(new Revista("Ciencia Hoy", "Orwell", LocalDate.of(2023, 1, 1), 45, "Ciencia Editorial"));
        biblioteca.agregarPublication(new ArticuloAcademico("Inteligencia Artificial", "María Pérez", LocalDate.of(2021, 3, 15), "MIT", true));
        biblioteca.agregarPublication(new Tesis("1984", "Andres", LocalDate.of(2025,5,20),"Universitario", "Nicole"));
        System.out.println("🟡 Publicaciones en cualquier orden:");
        biblioteca.imprimirPublicaciones();

        System.out.println("\n🟢 Publicaciones ordenadas por fecha:");
        biblioteca.imprimirPublicacionesOrdenadas();

        Map<String, List<Publication>> agrupadas = biblioteca.agruparPorAutor();

        for (Map.Entry<String, List<Publication>> entrada : agrupadas.entrySet()) {
            System.out.println("Autor: " + entrada.getKey());
            for (Publication p : entrada.getValue()) {
                System.out.println("  - " + p.getTitulo() + " (" + p.tipo() + ")");
            }
        }

        if (biblioteca.hayTitulosRepetidos()) {
            System.out.println("¡Hay títulos duplicados en la biblioteca!");
        } else {
            System.out.println("No hay títulos duplicados.");
        }
        Set<String> autoresLibros = biblioteca.autoresPorTipo("Libro");
        System.out.println("Autores");
        System.out.println(autoresLibros.toString());

        System.out.println("------------------");
        System.out.println(biblioteca.publicacionesPorAutores());

        System.out.println("-------- TIPO ----------");
        System.out.println(biblioteca.publicacionesPorTipo());

        System.out.println("------------------***************");
        System.out.println(biblioteca.contarPublicacionesPorAutor());
        System.out.println("------------------***************");
        System.out.println(biblioteca.contarPaginas());

        System.out.println("**********-----------***************");
        System.out.println(biblioteca.publicacionesPorAutor());

        Map<String, Map<String, Integer>> mapa = biblioteca.TipoYAutor();
        mapa.forEach((tipo, autoresMap) -> {
            System.out.println("Tipo: " + tipo);
            autoresMap.forEach((autor, cantidad) -> {
                System.out.println("  Autor: " + autor + " → " + cantidad);
            });
        });
*/




    public static void contarVocales(String palabra) {
        Map<Character, Integer> vocales = new HashMap<>();
        vocales.put('a', 0);
        vocales.put('e', 0);
        vocales.put('i', 0);
        vocales.put('o', 0);
        vocales.put('u', 0);
        for (char c : palabra.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vocales.put(c, vocales.getOrDefault(c, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : vocales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void palabraInversa(String palabra) {

        String[] palabras = palabra.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = palabras.length -1 ; i >= 0; i--) {
            builder.append(palabras[i]);
            if (i !=0){
                builder.append(" ");
            }
        }
        System.out.println(builder.toString());


    }

    public static void charRepetido(String palabra){
        Set<Character> repetidos = new HashSet<>();
        for (char c : palabra.toCharArray()) {
            if (repetidos.contains(c)) {
                System.out.println("Primer repetido: " + c);
                return;
            }else{
                repetidos.add(c);
            }
        }
        System.out.println("Todos los caracteres son únicos");


    }

    public static boolean anagrama(String a, String b) {
        if(a.length() != b.length()) return false;

        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(b1);

        return Arrays.equals(a1, b1);
    }


    public static void imprimirPrimos(int n){
        List<Integer> numero = new ArrayList();
        for (int i = 2; i <=n; i++){
            if(esPrimo(i)){
                numero.add(i);

            }
        }
        System.out.println(numero.toString());
    }

    public static boolean esPrimo(int numero){
        if(numero <=1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++){
            if(numero % i == 0) return false;
        }
        return true;
    }




}

