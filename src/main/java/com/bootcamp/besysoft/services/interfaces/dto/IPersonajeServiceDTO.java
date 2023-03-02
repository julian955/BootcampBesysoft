package com.bootcamp.besysoft.services.interfaces.dto;


import com.bootcamp.besysoft.dto.dto.PersonajeDTO;
import com.bootcamp.besysoft.dto.requestEntity.PersonajeRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;

import java.util.List;

public interface IPersonajeServiceDTO {

    PersonajeDTO findByName(String name) throws NullEntityException;

    List<PersonajeDTO> findAllPersonaje();

    List<PersonajeDTO> findPersonajeByEdad(Integer edad) throws NullEntityException;

    List<PersonajeDTO> findPersonajeBetweenEdad(Integer desde,Integer hasta) throws NullEntityException;

    PersonajeDTO generatePersonaje(PersonajeRE personaje) throws NullEntityException, InvalidNameException;

    PersonajeDTO updatePersonaje(Long id,PersonajeRE personaje) throws NullEntityException;
}
