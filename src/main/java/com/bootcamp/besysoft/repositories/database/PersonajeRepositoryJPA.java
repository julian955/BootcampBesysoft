package com.bootcamp.besysoft.repositories.database;

import com.bootcamp.besysoft.dominio.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonajeRepositoryJPA extends JpaRepository<Personaje,Long> {

    Optional<Personaje> findByNombre(String nombre);

    Optional<Personaje> findByNombreIgnoreCase(String nombre);

    List<Personaje> findByEdad(Integer edad);

    List<Personaje> findByEdadBetween(Integer c1, Integer c2);


}
