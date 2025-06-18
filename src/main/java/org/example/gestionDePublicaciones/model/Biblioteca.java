package org.example.gestionDePublicaciones.model;

import org.example.exception.PublicacionDuplicadaException;
import org.example.exception.PublicacionNoEncontradaException;

import java.util.*;

public class Biblioteca {
    private List<Publication> publications = new ArrayList<>();

    public void agregarPublication(Publication publication) throws PublicacionDuplicadaException {
        for (Publication existente : publications) {
            if (existente.getTitulo().equalsIgnoreCase(publication.getTitulo())) {
                throw new PublicacionDuplicadaException("Ya existe una publicación con el título: " + publication.getTitulo());
            }
        }
        publications.add(publication);
    }

    public List<Publication> buscarPorAutor(String autor) {
        return publications.stream()
                .filter(publication -> publication.getAutor().equals(autor))
                .toList();
    }

    public List<Publication> listarPublicacionesRecientes() {
        return publications.stream()
                .filter(Publication::esReciente)
                .toList();

    }

    public void eliminarPorTitulo(String titulo) {
        boolean eliminar = publications
                .removeIf(publication -> publication.getTitulo().equals(titulo));
        if (!eliminar) {
            System.out.println("No se elimino el titulo " + titulo + " ya que no se encuentra");
        }
    }

    public List<Publication> mostrarTodosPublications() {
        return publications;
    }

    public void imprimirPublicaciones() {
        publications.forEach(Publication::imprimir);

    }

    public void imprimirPublicacionesOrdenadas() {
        List<Publication> ordenadas = new ArrayList<>(publications);
        Collections.sort(ordenadas);
        ordenadas.forEach(Publication::imprimir);

    }

    public Map<String, List<Publication>> agruparPorAutor() {
        Map<String, List<Publication>> autores = new HashMap<>();
        for (Publication publication : publications) {
            autores
                    .computeIfAbsent(publication.getAutor(), k -> new ArrayList<>())
                    .add(publication);
        }
        return autores;
    }

    public boolean hayTitulosRepetidos(){
        Set<String> titulosRepetidos = new HashSet<>();
        for (Publication p : publications) {
            if(titulosRepetidos.contains(p.getTitulo())){
                return true;
            }else {
                titulosRepetidos.add(p.getTitulo());
            }
        }
        return false;

    }

    public Set<String> autoresPorTipo(String tipo) {
        Set<String> autoresPorTipo = new HashSet<>();
        for (Publication p : publications) {
            if(p.tipo().equals(tipo)){
                autoresPorTipo.add(p.getAutor());
            }
        }
        return autoresPorTipo;
    }

    public Map<String, List<Publication>> publicacionesPorAutores(){
        Map<String, List<Publication>> map = new HashMap<>();

        for (Publication p : publications) {
            String autor = p.getAutor();

            // Si el autor ya está como clave, agregamos la publicación a su lista
            if (!map.containsKey(autor)) {
                map.put(autor, new ArrayList<>()); // Creamos nueva lista si no existe
            }

            map.get(autor).add(p); // Añadimos la publicación a la lista del autor
        }

        return map;
    }

    public Map<String, List<Publication>> publicacionesPorTipo(){
        Map<String, List<Publication>> map = new HashMap<>();
        for (Publication p : publications) {
            String tipo = p.tipo();

            if (!map.containsKey(tipo)) {
                map.put(tipo, new ArrayList<>());
            }
            map.get(tipo).add(p);
        }
        return map;
    }
/*    public Map<String, List<Publication>> publicacionesPorTipo() {
        return publications.stream()
                .collect(Collectors.groupingBy(Publication::tipo));
    }*/

    public Map<String, Integer> contarPublicacionesPorAutor(){
        Map<String, Integer> contador = new HashMap<>();
        for (Publication p : publications){
            String autor = p.getAutor();
            contador.put(autor, contador.getOrDefault(autor, 0) + 1);

        }
        return contador;
    }

    public Map<String, Integer> contarPaginas(){
        Map<String, Integer> contador = new HashMap<>();

        for (Publication p : publications) {

            int paginas = 0;

            if (p instanceof Libro) {
                paginas = ((Libro) p).getNumeroPaginas();
            } else if (p instanceof Revista) {
                paginas = ((Revista) p).getNumero(); // Suponiendo que "numero" es el número de páginas
            }else {
                continue;
            }

            String tipo = p.tipo();
            // Sumar al valor actual (o 0 si aún no existe)
            contador.put(tipo, contador.getOrDefault(tipo, 0) + paginas);
        }

        return contador;
    }


    public Map<String, List<Publication>> publicacionesPorAutor(){
        Map<String, List<Publication>> map = new HashMap<>();
        for (Publication p : publications) {
            String autor = p.getAutor();
            map.computeIfAbsent(autor, k -> new ArrayList<>()).add(p);
        }
        return map;
    }

    public Map<String, Map<String, Integer>> TipoYAutor(){
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (Publication p : publications) {
            String autor = p.getAutor();
            String tipo = p.tipo();
            if (!map.containsKey(tipo)) {
                map.put(tipo, new HashMap<>());
            }
            // Obtenemos el mapa interno para ese tipo
            Map<String, Integer> mapaAutores = map.get(tipo);
            mapaAutores.put(autor, mapaAutores.getOrDefault(autor, 0) + 1);
        }

        return map;
    }
    public Publication buscarPorTitulo(String titulo) throws PublicacionNoEncontradaException {
        for (Publication p : publications) {
            if(p.getTitulo().equalsIgnoreCase(titulo)){
                return p;
            }
        }
        throw new PublicacionNoEncontradaException("No se encontro el titulo: " + titulo);
    }
}
