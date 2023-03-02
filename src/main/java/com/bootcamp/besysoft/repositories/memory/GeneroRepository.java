package com.bootcamp.besysoft.repositories.memory;

import com.bootcamp.besysoft.dominio.Genero;
import com.bootcamp.besysoft.dominio.Pelicula;


import java.util.List;
import java.util.Optional;


public interface GeneroRepository {

    List<Genero> getAll();

    Genero addGenero(Genero genero);

    Optional<Genero> findById(Long id);

    List<Pelicula> getPeliculaByGenero(String genero);
}
