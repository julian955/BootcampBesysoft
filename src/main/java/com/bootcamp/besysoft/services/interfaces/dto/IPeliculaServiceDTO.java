package com.bootcamp.besysoft.services.interfaces.dto;

import com.bootcamp.besysoft.dto.dto.PeliculaDTO;
import com.bootcamp.besysoft.dto.requestEntity.PeliculaRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;

import java.time.LocalDate;
import java.util.List;

public interface IPeliculaServiceDTO {


    List<PeliculaDTO> findAllPelicula();

    PeliculaDTO findByTitle(String title) throws NullEntityException;

    List<PeliculaDTO> findPeliculaByGenero(String genero) throws NullEntityException;

    List<PeliculaDTO> findPeliculaBetweenDates(LocalDate date1, LocalDate date2) throws NullEntityException;

    List<PeliculaDTO> findPeliculaBetweenCalification(Integer desde, Integer hasta) throws NullEntityException;

    PeliculaDTO generatePelicula(PeliculaRE pelicula) throws NullEntityException, InvalidNameException;

    PeliculaDTO updatePelicula(Long id,PeliculaRE pelicula) throws NullEntityException;
}
