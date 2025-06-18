package org.example.gestionDePublicaciones.Repository;

import org.example.gestionDePublicaciones.model.Publication;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPublicationRepository implements PublicationRepository{
    private final List<Publication> publications = new ArrayList<>();
    @Override
    public void agregar(Publication p) {
        publications.add(p);

    }

    @Override
    public List<Publication> obtenerTodas() {
        return publications;
    }
}
