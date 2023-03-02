package com.bootcamp.besysoft.repositories.database;

import com.bootcamp.besysoft.dominio.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PeliculaRepositoryJPA extends JpaRepository<Pelicula,Long> {

    Optional<Pelicula> findByTituloIgnoreCase(String titulo);

    Optional<Pelicula> findByTitulo(String titulo);

    List<Pelicula> findByEstrenoBetween(LocalDate d1,LocalDate d2);

    List<Pelicula> findByCalificacionBetween(Integer c1,Integer c2);
}
