package org.example.gestionDePublicaciones.controller;

import org.example.gestionDePublicaciones.model.Libro;
import org.example.gestionDePublicaciones.model.Publication;
import org.example.gestionDePublicaciones.model.Revista;
import org.example.gestionDePublicaciones.service.BibliotecaService;

import java.time.LocalDate;
import java.util.Scanner;

public class BibliotecaController {
    private final BibliotecaService service;
    private final Scanner scanner;

    public BibliotecaController(BibliotecaService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1 -> agregarLibro();
                case 2 -> agregarRevista();
                case 3 -> listarPublicaciones();
                case 4 -> contarPaginas();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("""
            ----- BIBLIOTECA -----
            1. Agregar libro
            2. Agregar revista
            3. Listar publicaciones
            4. Contar páginas por tipo
            0. Salir
            ------------------------
            Selecciona una opción:
        """);
    }

    private void agregarLibro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año (yyyy): ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Mes (1-12): ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Día: ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.print("Número de páginas: ");
        int paginas = Integer.parseInt(scanner.nextLine());

        Publication libro = new Libro(titulo, autor, LocalDate.of(year, month, day), paginas);
        service.agregar(libro);
        System.out.println("📚 Libro agregado.");
    }

    private void agregarRevista() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año (yyyy): ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Mes (1-12): ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Día: ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.print("Número: ");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.print("Editorial: ");
        String editorial = scanner.nextLine();

        Publication revista = new Revista(titulo, autor, LocalDate.of(year, month, day), numero, editorial);
        service.agregar(revista);
        System.out.println("📰 Revista agregada.");
    }

    private void listarPublicaciones() {
        System.out.println("📄 Lista de publicaciones:");
        service.obtenerTodas().forEach(System.out::println);
    }

    private void contarPaginas() {
        System.out.println("📊 Páginas por tipo:");
        service.contarPaginas().forEach((tipo, total) ->
                System.out.println(tipo + ": " + total + " páginas"));
    }

    /*public void agregarEjemplo() {
        Publication libro = new Libro("El Quijote", "Cervantes", LocalDate.of(1605, 1, 16), 500);
        bibliotecaService.agregar(libro);
        System.out.println("Libro agregado correctamente.");
    }

    public void mostrarPublicaciones() {
        for (Publication p : bibliotecaService.obtenerTodas()) {
            System.out.println(p);
        }
    }*/
}
