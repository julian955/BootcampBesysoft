package com.bootcamp.besysoft.services.interfaces.entity;

import com.bootcamp.besysoft.dominio.Genero;

import java.util.List;

public interface IGeneroService {

    List<Genero> getAllGenero();

    Genero createGenero(Genero genero);

    Genero updateGenero(Long id,Genero genero);
}
