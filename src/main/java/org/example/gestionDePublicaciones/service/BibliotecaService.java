package org.example.gestionDePublicaciones.service;

import org.example.gestionDePublicaciones.Repository.PublicationRepository;
import org.example.gestionDePublicaciones.model.Libro;
import org.example.gestionDePublicaciones.model.Publication;
import org.example.gestionDePublicaciones.model.Revista;

import java.util.*;

public class BibliotecaService {
    private final PublicationRepository repo;


    public BibliotecaService(PublicationRepository repo) {
        this.repo = repo;
    }

    public void agregar(Publication publication) {
        repo.agregar(publication);
    }

    public boolean hayTitulosRepetidos() {
        Set<String> titulos = new HashSet<>();
        for (Publication p : repo.obtenerTodas()) {
            if (!titulos.add(p.getTitulo())) return true;
        }
        return false;
    }
    public List<Publication> obtenerTodas() {
        return repo.obtenerTodas();
    }

    public Map<String, Integer> contarPaginas(){
        Map<String, Integer> contador = new HashMap<>();

        for (Publication p : repo.obtenerTodas()) {

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
}
