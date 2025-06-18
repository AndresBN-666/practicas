package BibliotecaTest;

import org.example.exception.PublicacionDuplicadaException;
import org.example.gestionDePublicaciones.Repository.InMemoryPublicationRepository;
import org.example.gestionDePublicaciones.Repository.PublicationRepository;
import org.example.gestionDePublicaciones.model.Biblioteca;
import org.example.gestionDePublicaciones.model.Libro;
import org.example.gestionDePublicaciones.model.Revista;
import org.example.gestionDePublicaciones.service.BibliotecaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTesting {

    private BibliotecaService service;

    @BeforeEach
    void setUp() {
        PublicationRepository repo = new InMemoryPublicationRepository();
        service = new BibliotecaService(repo);

        service.agregar(new Libro("1984", "Orwell", LocalDate.of(1949, 6, 8), 100));
        service.agregar(new Revista("Ciencia Hoy", "Varios", LocalDate.of(2023, 1, 1), 45, "Ciencia Editorial"));
        service.agregar(new Libro("Yolonaste", "Orwell", LocalDate.of(1949, 6, 8), 185));
        service.agregar(new Revista("Ciencia Mañana", "Varios", LocalDate.of(2023, 1, 1), 145, "Ciencia Editorial"));
    }

    @Test
    public void contarPagina() {

        Map<String, Integer> resultado = service.contarPaginas();

        assertEquals(285, resultado.get("Libro"));      // 100 + 185
        assertEquals(190, resultado.get("Revista"));    // 45 + 145
        assertEquals(2, resultado.size());
    }
}
