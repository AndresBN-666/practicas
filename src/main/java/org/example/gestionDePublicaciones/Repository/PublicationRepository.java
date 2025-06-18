package org.example.gestionDePublicaciones.Repository;

import org.example.gestionDePublicaciones.model.Publication;

import java.util.List;

public interface PublicationRepository {
    void agregar(Publication p);
    List<Publication> obtenerTodas();
}
