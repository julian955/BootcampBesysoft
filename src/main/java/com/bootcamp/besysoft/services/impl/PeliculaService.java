package com.bootcamp.besysoft.services.impl;


import com.bootcamp.besysoft.dominio.Pelicula;
import com.bootcamp.besysoft.repositories.memory.GeneroRepository;
import com.bootcamp.besysoft.repositories.memory.PeliculaRepository;
import com.bootcamp.besysoft.services.interfaces.entity.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService implements IPeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private GeneroRepository generoRepository;


    @Override
    public List<Pelicula> findAllPelicula() {

        List<Pelicula> list = peliculaRepository.findAll();
        if (list.isEmpty()) {
            return null;
        }

        return list;
    }

    @Override
    public Pelicula findByTitle(String title) {

        Optional<Pelicula> pelicula = peliculaRepository.findByTitle(title);

        if (pelicula.isEmpty()) {
            return null;
        }

        return pelicula.get();
    }

    @Override
    public List<Pelicula> findPeliculaByGenero(String genero) {

        List<Pelicula> peliculaList = generoRepository.getPeliculaByGenero(genero);

        if (peliculaList.isEmpty()) {
            return null;
        }

        return peliculaList;
    }

    @Override
    public List<Pelicula> findPeliculaBetweenDates(LocalDate date1, LocalDate date2) {


        List<Pelicula> list = peliculaRepository.findAll();

        List<Pelicula> response = list.stream()
                .filter(p -> p.getEstreno().isAfter(date1))
                .filter(p -> p.getEstreno().isBefore(date2)).toList();

        if (response == null) {
            return null;
        }
        return response;
    }

    @Override
    public List<Pelicula> findPeliculaBetweenCalification(Integer desde, Integer hasta) {

        List<Pelicula> list = peliculaRepository.findAll();

        List<Pelicula> response = list.stream()
                .filter(p -> p.getCalificacion() >= desde)
                .filter(p -> p.getCalificacion() <= hasta).toList();

        if (response == null) {
            return null;
        }
        return response;
    }

    @Override
    public Pelicula generatePelicula(Pelicula pelicula) {

        if (pelicula == null){
            return null;
        }

        if (!this.validarTitulo(pelicula.getTitulo())){
            return null;
        }
        pelicula.setId((long) peliculaRepository.findAll().size() + 1);

        peliculaRepository.save(pelicula);

        return pelicula;
    }

    @Override
    public Pelicula updatePelicula(Long id, Pelicula pelicula) {

        Optional<Pelicula> peliculaOptional = peliculaRepository.findById(id);


        if (peliculaOptional.isEmpty()) {
            return null;
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
        if (pelicula.getPersonajes() != null) {
            response.setPersonajes(pelicula.getPersonajes());
        }

        peliculaRepository.save(response);

        return response;

    }

    private Boolean validarTitulo(String titulo){

        List<Pelicula> list = peliculaRepository.findAll();

        Optional<Pelicula> response = list.stream().filter(p -> p.getTitulo().equalsIgnoreCase(titulo)).findAny();

        return response.isEmpty();
    }


}
