package com.bootcamp.besysoft.services.impJPA;

import com.bootcamp.besysoft.dto.dto.PeliculaDTO;
import com.bootcamp.besysoft.dto.requestEntity.PeliculaRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;
import com.bootcamp.besysoft.services.interfaces.dto.IPeliculaServiceDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PeliculaServiceJPATest {

    @Autowired
    private IPeliculaServiceDTO service;

    @Test
    void findAllPelicula() {

        List<PeliculaDTO> peliculaList = service.findAllPelicula();

        assertThat(peliculaList).isNotNull();
    }

    @Test
    void findByTitle() throws NullEntityException {

        String title = "guason";

        PeliculaDTO response = service.findByTitle(title);

        assertThat(response).isNotNull();
        assertThat(response.getTitulo()).isEqualToIgnoringCase(title);
    }

    @Test
    void findByTitle_invalidTitle() throws NullEntityException {

        String title = "test";

        assertThrowsExactly(NullEntityException.class, () -> service.findByTitle(title));



    }

    @Test
    void findPeliculaByGenero() throws NullEntityException {

        String genero = "terror";

        List<PeliculaDTO> peliculaList = service.findPeliculaByGenero(genero);

        assertThat(peliculaList).isNotNull();
    }

    @Test
    void findPeliculaByGenero_invalidName() throws NullEntityException {

        String genero = "test";

        assertThrowsExactly(NullEntityException.class, () -> service.findPeliculaByGenero(genero));
    }

    @Test
    void findPeliculaBetweenDates() throws NullEntityException {

        LocalDate date1 = LocalDate.of(2003,05,20);
        LocalDate date2 = LocalDate.of(2010,10,10);

        List<PeliculaDTO> peliculaList = service.findPeliculaBetweenDates(date1,date2);

        assertThat(peliculaList).isNotNull();
    }

    @Test
    void findPeliculaBetweenDates_invalidDates() throws NullEntityException {

        LocalDate date1 = LocalDate.of(2022,05,20);
        LocalDate date2 = LocalDate.of(2023,10,10);


        assertThrowsExactly(NullEntityException.class, () -> service.findPeliculaBetweenDates(date1,date2));


    }

    @Test
    void findPeliculaBetweenCalification() throws NullEntityException {


        List<PeliculaDTO> peliculaList = service.findPeliculaBetweenCalification(1,2);

        assertThat(peliculaList).isNotNull();
    }

    @Test
    void findPeliculaBetweenCalification_invalidCalification() throws NullEntityException {


        assertThrowsExactly(NullEntityException.class, () ->  service.findPeliculaBetweenCalification(5,1));


    }

    @Test
    void generatePelicula() throws InvalidNameException, NullEntityException {

        PeliculaRE pelicula = new PeliculaRE("Pelicula 1",null,5,1L, Set.of(1L,2L,3L));

        PeliculaDTO response = service.generatePelicula(pelicula);

        assertThat(response).isNotNull();
        assertThat(response.getTitulo()).isEqualTo("Pelicula 1");
        assertThat(response.getNombreGenero()).isEqualTo("Terror");
        assertThat(response.getPersonajes()).isNotNull();

    }

    @Test
    void generatePelicula_nullRE() throws InvalidNameException, NullEntityException {

        PeliculaRE pelicula = null;

        assertThrowsExactly(NullEntityException.class, () ->  service.generatePelicula(pelicula));

    }

    @Test
    void generatePelicula_invalidTitle() throws InvalidNameException, NullEntityException {

        PeliculaRE pelicula = new PeliculaRE("Guason",null,5,1L, Set.of(1L,2L,3L));


        assertThrowsExactly(InvalidNameException.class, () ->  service.generatePelicula(pelicula));

    }

    @Test
    void generatePelicula_invalidGenero() throws InvalidNameException, NullEntityException {

        PeliculaRE pelicula = new PeliculaRE("Peli",null,5,8L, Set.of(1L,2L,3L));


        assertThrowsExactly(InvalidNameException.class, () ->  service.generatePelicula(pelicula));



    }

    @Test
    void updatePelicula() throws NullEntityException {
        PeliculaRE pelicula = new PeliculaRE("test",null,5,1L, Set.of(1L,2L,3L));
        PeliculaDTO response = service.updatePelicula(1L,pelicula);
        assertThat(response).isNotNull();
        assertThat(response.getTitulo()).isEqualTo("test");
        assertThat(response.getNombreGenero()).isEqualTo("Terror");
        assertThat(response.getPersonajes()).isNotNull();
    }

    @Test
    void updatePelicula_invalidId() throws NullEntityException {
        PeliculaRE pelicula = new PeliculaRE("test",null,5,1L, Set.of(1L,2L,3L));

        assertThrowsExactly(NullEntityException.class, () ->  service.updatePelicula(25L,pelicula));
    }
}