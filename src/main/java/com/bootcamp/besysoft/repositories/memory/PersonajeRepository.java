package com.bootcamp.besysoft.repositories.memory;

import com.bootcamp.besysoft.dominio.Personaje;

import java.util.List;
import java.util.Optional;

public interface PersonajeRepository {

    List<Personaje> getAll();

    Optional<Personaje> findById(Long id);

    Optional<Personaje> findByName(String name);

    Personaje save(Personaje personaje);
}
