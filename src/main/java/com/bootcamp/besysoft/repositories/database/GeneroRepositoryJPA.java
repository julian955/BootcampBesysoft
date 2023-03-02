package com.bootcamp.besysoft.repositories.database;

import com.bootcamp.besysoft.dominio.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepositoryJPA extends JpaRepository<Genero,Long> {

    Optional<Genero> findByNombreIgnoreCase(String name);
}
