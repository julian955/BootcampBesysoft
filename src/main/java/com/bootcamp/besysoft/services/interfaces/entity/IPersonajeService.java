package com.bootcamp.besysoft.services.interfaces.entity;

import com.bootcamp.besysoft.dominio.Personaje;

import java.util.List;

public interface IPersonajeService {

    Personaje findByName(String name);

    List<Personaje> findAllPersonaje();

    List<Personaje> findPersonajeByEdad(Integer edad);

    List<Personaje> findPersonajeBetweenEdad(Integer desde,Integer hasta);

    Personaje generatePersonaje(Personaje personaje);

    Personaje updatePersonaje(Long id,Personaje personaje);
}
