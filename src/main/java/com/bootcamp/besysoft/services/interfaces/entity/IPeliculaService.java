package com.bootcamp.besysoft.services.interfaces.entity;

import com.bootcamp.besysoft.dominio.Pelicula;


import java.time.LocalDate;
import java.util.List;


public interface IPeliculaService {

    List<Pelicula> findAllPelicula();

    Pelicula findByTitle(String title);

    List<Pelicula> findPeliculaByGenero(String genero);

    List<Pelicula> findPeliculaBetweenDates(LocalDate date1, LocalDate date2);

    List<Pelicula> findPeliculaBetweenCalification(Integer desde, Integer hasta);

    Pelicula generatePelicula(Pelicula pelicula);

    Pelicula updatePelicula(Long id,Pelicula pelicula);
}
