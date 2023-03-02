package com.bootcamp.besysoft.services.impJPA;

import com.bootcamp.besysoft.dominio.Pelicula;
import com.bootcamp.besysoft.dominio.Personaje;
import com.bootcamp.besysoft.dto.dto.PersonajeDTO;
import com.bootcamp.besysoft.dto.mapper.PersonajeMapper;
import com.bootcamp.besysoft.dto.requestEntity.PersonajeRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;
import com.bootcamp.besysoft.repositories.database.PeliculaRepositoryJPA;
import com.bootcamp.besysoft.repositories.database.PersonajeRepositoryJPA;
import com.bootcamp.besysoft.services.interfaces.dto.IPersonajeServiceDTO;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Primary
@AllArgsConstructor
public class PersonajeServiceJPA implements IPersonajeServiceDTO {

    private PersonajeRepositoryJPA repository;

    private PeliculaRepositoryJPA peliculaRepositoryJPA;

    private PersonajeMapper personajeMapper;

    @Override
    public PersonajeDTO findByName(String name) throws NullEntityException {

        Optional<Personaje> personaje = repository.findByNombreIgnoreCase(name);

        if (personaje.isEmpty()){
            throw new NullEntityException("No se encontro el personaje con el nombre ingresado.");
        }

        return personajeMapper.mapToDTO(personaje.get());
    }

    @Override
    public List<PersonajeDTO> findAllPersonaje() {

        List<Personaje> list = repository.findAll();

        if (list.isEmpty()){
            return null;
        }

        return personajeMapper.listToDTO(list);
    }

    @Override
    public List<PersonajeDTO> findPersonajeByEdad(Integer edad) throws NullEntityException {
        List<Personaje> list = repository.findByEdad(edad);

        if (list.isEmpty()){
            throw new NullEntityException("No se encontraron personajes con la edad ingresada.");
        }

        return personajeMapper.listToDTO(list);
    }

    @Override
    public List<PersonajeDTO> findPersonajeBetweenEdad(Integer desde, Integer hasta) throws NullEntityException {

        List<Personaje> list = repository.findByEdadBetween(desde,hasta);

        if (list.isEmpty()){
            throw new NullEntityException("No se encontraron personajes con la edad ingresada.");
        }

        return personajeMapper.listToDTO(list);
    }

    @Override
    public PersonajeDTO generatePersonaje(PersonajeRE personaje) throws NullEntityException, InvalidNameException {
        if (personaje == null){
            throw new NullEntityException("No se puede guardar un personajes nulo.");
        }

        if (!this.validarNombre(personaje.getNombre())){
            throw new InvalidNameException("El nombre ingresado ya existe.");
        }

        Personaje entity = personajeMapper.mapREToEntity(personaje);

        List<Pelicula> peli= personaje.
                getPeliculaId().
                stream().
                map(this::validarPersonaje).
                collect(Collectors.toList());

        peli.removeIf(Objects::isNull);

        entity.setPeliculas(peli);
        repository.save(entity);

        return personajeMapper.mapToDTO(entity);
    }

    @Override
    public PersonajeDTO updatePersonaje(Long id, PersonajeRE pers) throws NullEntityException {

        if (pers == null){
            throw new NullEntityException("No se puede guardar un personajes nulo.");
        }

        Optional<Personaje> personaje = repository.findById(id);

        if (personaje.isEmpty()){
            throw new NullEntityException("No se encontraron personajes con el id ingresado.");
        }

        Personaje p = personaje.get();

        if (pers.getNombre() != null){
            p.setNombre(pers.getNombre());
        }
        if (pers.getEdad() != null){
            p.setEdad(pers.getEdad());
        }
        if (pers.getPeso() != null){
            p.setPeso(pers.getPeso());
        }
        if (pers.getHistoria() != null){
            p.setHistoria(pers.getHistoria());
        }

        repository.save(p);

        return personajeMapper.mapToDTO(p);
    }

    private Boolean validarNombre(String nombre){

        if (nombre == null){
            return false;
        }


        Optional<Personaje> response = repository.findByNombre(nombre);

        return response.isEmpty();
    }


    private Pelicula validarPersonaje(Long id){

        Optional<Pelicula> pelicula = peliculaRepositoryJPA.findById(id);

        return pelicula.orElse(null);
    }
}
