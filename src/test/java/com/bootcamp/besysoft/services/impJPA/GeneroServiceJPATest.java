package com.bootcamp.besysoft.services.impJPA;


import com.bootcamp.besysoft.dto.dto.GeneroDTO;
import com.bootcamp.besysoft.dto.requestEntity.GeneroRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;
import com.bootcamp.besysoft.services.interfaces.dto.IGeneroServiceDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;


@SpringBootTest
class GeneroServiceJPATest {

    @Autowired
    private IGeneroServiceDTO service;




    @Test
    void getAllGenero() {
        List<GeneroDTO> generoList = service.getAllGenero();

        assertThat(generoList).isNotNull();
    }

    @Test
    void createGenero() throws InvalidNameException, NullEntityException {
       GeneroDTO response = service.createGenero(new GeneroRE("Genero creado"));

        assertThat(response).isNotNull();
    }


    @Test()
    void createGenero_generoNulo() throws InvalidNameException, NullEntityException {

        assertThrowsExactly(NullEntityException.class, () -> service.createGenero(null));
    }

    @Test
    void createGenero_nombreExistente() throws InvalidNameException, NullEntityException {

        GeneroRE test = new GeneroRE("tesst");
        service.createGenero(test);

        assertThrowsExactly(InvalidNameException.class, () -> service.createGenero(test));

    }

    @Test
    void updateGenero() throws NullEntityException {
        GeneroDTO response = service.updateGenero(1L,new GeneroRE("Test"));

        assertThat(response).isNotNull();
    }

    @Test
    void updateGenero_invalidId() throws NullEntityException {

        assertThrowsExactly(NullEntityException.class, () -> service.updateGenero(9L,new GeneroRE("Test")));

    }
}