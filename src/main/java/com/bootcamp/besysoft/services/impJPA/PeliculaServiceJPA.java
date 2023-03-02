package com.bootcamp.besysoft.services.impJPA;

import com.bootcamp.besysoft.dominio.Genero;
import com.bootcamp.besysoft.dominio.Pelicula;
import com.bootcamp.besysoft.dominio.Personaje;
import com.bootcamp.besysoft.dto.dto.PeliculaDTO;
import com.bootcamp.besysoft.dto.mapper.PeliculaMapper;
import com.bootcamp.besysoft.dto.requestEntity.PeliculaRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;
import com.bootcamp.besysoft.repositories.database.GeneroRepositoryJPA;
import com.bootcamp.besysoft.repositories.database.PeliculaRepositoryJPA;
import com.bootcamp.besysoft.repositories.database.PersonajeRepositoryJPA;
import com.bootcamp.besysoft.services.interfaces.dto.IPeliculaServiceDTO;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Primary
@AllArgsConstructor
public class PeliculaServiceJPA implements IPeliculaServiceDTO {

    private PeliculaRepositoryJPA repository;

    private GeneroRepositoryJPA generoRepositoryJPA;

    private PersonajeRepositoryJPA personajeRepositoryJPA;

    private PeliculaMapper peliculaMapper;

    @Override
    public List<PeliculaDTO> findAllPelicula() {

        List<Pelicula> list = repository.findAll();

        return peliculaMapper.listToDTO(list);
    }

    @Override
    public PeliculaDTO findByTitle(String title) throws NullEntityException {
        Optional<Pelicula> peliculaOpt = repository.findByTituloIgnoreCase(title);

        if (peliculaOpt.isEmpty()) {
            throw new NullEntityException("No se encontro la pelicula con el titulo ingresado.");
        }

        Pelicula pelicula = peliculaOpt.get();

        return peliculaMapper.mapToDTO(pelicula);
    }


    @Override
    public List<PeliculaDTO> findPeliculaByGenero(String genero) throws NullEntityException {

        Optional<Genero> gen = generoRepositoryJPA.findByNombreIgnoreCase(genero);

        if (gen.isEmpty()){
            throw new NullEntityException("No se encontraron peliculas con el genero ingresado.");
        }

        List<Pelicula> list = gen.get().getPeliculas();

        return peliculaMapper.listToDTO(list);
    }

    @Override
    public List<PeliculaDTO> findPeliculaBetweenDates(LocalDate date1, LocalDate date2) throws NullEntityException {

        List<Pelicula> list = repository.findByEstrenoBetween(date1,date2);
        if (list.isEmpty()){
            throw new NullEntityException("No se encontraron peliculas.");
        }
        return peliculaMapper.listToDTO(list);
    }

    @Override
    public List<PeliculaDTO> findPeliculaBetweenCalification(Integer desde, Integer hasta) throws NullEntityException {

        List<Pelicula> list = repository.findByCalificacionBetween(desde,hasta);
        if (list.isEmpty()){
            throw new NullEntityException("No se encontraron peliculas.");
        }
        return peliculaMapper.listToDTO(list);
    }

    @Override
    public PeliculaDTO generatePelicula(PeliculaRE pelicula) throws NullEntityException, InvalidNameException {

        if (pelicula == null){
            throw new NullEntityException("No se puede guardar una pelicula nula.");
        }

        if (!this.validarTitulo(pelicula.getTitulo())){
            throw new InvalidNameException("El nombre ingresado ya existe.");
        }

        if (this.validarGenero(pelicula.getGeneroId()) == null){
            throw new InvalidNameException("El genero ingresado es invalido.");
        }


        Pelicula entity = peliculaMapper.mapREToEntity(pelicula);

        entity.setGenero(this.validarGenero(pelicula.getGeneroId()));


        entity.setPersonajes(this.obtenerPersonajes(pelicula.getPersonajesId()));

        repository.save(entity);


        PeliculaDTO dto = peliculaMapper.mapToDTO(entity);

        return dto;
    }

    @Override
    public PeliculaDTO updatePelicula(Long id, PeliculaRE pelicula) throws NullEntityException {

        Optional<Pelicula> peliculaOptional = repository.findById(id);

        if (peliculaOptional.isEmpty()) {
            throw new NullEntityException("No se encontraron peliculas con el id ingresado.");
        }

        Pelicula response = peliculaOptional.get();

        if (pelicula.getTitulo() != null) {
            response.setTitulo(pelicula.getTitulo());
        }
        if (pelicula.getEstreno() != null) {
            response.setEstreno(pelicula.getEstreno());
        }
        if (pelicula.getCalificacion() != null) {
            response.setCalificacion(pelicula.getCalificacion());
        }
        if (pelicula.getPersonajesId() != null){
            response.setPersonajes(this.obtenerPersonajes(pelicula.getPersonajesId()));
        }

        repository.save(response);
        return peliculaMapper.mapToDTO(response);
    }

    private Boolean validarTitulo(String titulo){

        Optional<Pelicula> response = repository.findByTitulo(titulo);

        return response.isEmpty();
    }

    private Genero validarGenero(Long id){

        Optional<Genero> genero = generoRepositoryJPA.findById(id);

         if (!genero.isEmpty()){
             return genero.get();
         }

         return null;
    }

    private Personaje validarPersonaje(Long id){

        Optional<Personaje> personaje = personajeRepositoryJPA.findById(id);

        if (personaje.isPresent()){
            return personaje.get();
        }

        return null;
    }

    private List<Personaje> obtenerPersonajes(Set<Long> personajesId){

        List<Personaje> personajes = personajesId
                .stream()
                .map(this::validarPersonaje)
                .collect(Collectors.toList());

        personajes.removeIf(Objects::isNull);

        if (personajes == null){
            return null;
        }
        return personajes;

    }

}
