package com.bootcamp.besysoft.repositories.memory;

import com.bootcamp.besysoft.dominio.Pelicula;


import java.util.List;
import java.util.Optional;


public interface PeliculaRepository {

    List<Pelicula> findAll();

    Optional<Pelicula> findByTitle(String title);

    Pelicula save(Pelicula pelicula);

    Optional<Pelicula> findById(Long id);
}
