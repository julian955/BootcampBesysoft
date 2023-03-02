package com.bootcamp.besysoft.services.impJPA;

import com.bootcamp.besysoft.dto.dto.PersonajeDTO;
import com.bootcamp.besysoft.dto.requestEntity.PersonajeRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;
import com.bootcamp.besysoft.services.interfaces.dto.IPersonajeServiceDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PersonajeServiceJPATest {

    @Autowired
    private IPersonajeServiceDTO service;

    @Test
    void findByName() throws NullEntityException {
        String name = "Johnny Depp";

        PersonajeDTO response = service.findByName(name);

        assertThat(response).isNotNull();
        assertThat(response.getNombre()).isEqualTo(name);
    }

    @Test
    void findByName_invalidName() throws NullEntityException {
        String name = "test name";

        assertThrowsExactly(NullEntityException.class, () ->  service.findByName(name));
    }

    @Test
    void findAllPersonaje() {

        List<PersonajeDTO> personajeList = service.findAllPersonaje();

        assertThat(personajeList).isNotNull();
    }

    @Test
    void findPersonajeByEdad() throws NullEntityException {

        Integer edad = 50;

        List<PersonajeDTO> personajeList = service.findPersonajeByEdad(edad);

        assertThat(personajeList).isNotNull();
    }

    @Test
    void findPersonajeByEdad_edadInvalida() throws NullEntityException {

        Integer edad = 99;

        assertThrowsExactly(NullEntityException.class, () ->  service.findPersonajeByEdad(edad));
    }

    @Test
    void findPersonajeBetweenEdad() throws NullEntityException {

        Integer desde  = 50;
        Integer hasta  = 60;

        List<PersonajeDTO> personajeList = service.findPersonajeBetweenEdad(desde,hasta);

        assertThat(personajeList).isNotNull();
    }

    @Test
    void findPersonajeBetweenEdad_edadInvalida() throws NullEntityException {

        Integer desde  = 98;
        Integer hasta  = 99;

        assertThrowsExactly(NullEntityException.class, () ->  service.findPersonajeBetweenEdad(desde,hasta));
    }

    @Test
    void generatePersonaje() throws InvalidNameException, NullEntityException {

        PersonajeRE personaje = new PersonajeRE("nombre",65,80.5,"historia", Set.of(1L,2L,3L));

        PersonajeDTO response = service.generatePersonaje(personaje);

        assertThat(response).isNotNull();
        assertThat(response.getNombre()).isEqualTo("nombre");
        assertThat(response.getEdad()).isEqualTo(65);
        assertThat(response.getHistoria()).isEqualTo("historia");
        assertThat(response.getPeso()).isEqualTo(80.5);
        assertThat(response.getPeliculas()).isNotNull();
    }

    @Test
    void generatePersonaje_personajeNulo() throws InvalidNameException, NullEntityException {

        PersonajeRE personaje = null;

        assertThrowsExactly(NullEntityException.class, () ->  service.generatePersonaje(personaje));
    }

    @Test
    void generatePersonaje_nombreExistente() throws InvalidNameException, NullEntityException {

        PersonajeRE personaje = new PersonajeRE("Johnny Depp",65,80.5,"historia", Set.of(1L,2L,3L));

        assertThrowsExactly(InvalidNameException.class, () ->  service.generatePersonaje(personaje));
    }

    @Test
    void generatePersonaje_nombreNulo() throws InvalidNameException, NullEntityException {

        PersonajeRE personaje = new PersonajeRE(null,65,80.5,"historia", Set.of(1L,2L,3L));

        assertThrowsExactly(InvalidNameException.class, () ->  service.generatePersonaje(personaje));
    }

    @Test
    void updatePersonaje() throws NullEntityException {

        PersonajeRE personaje = new PersonajeRE("nombre",65,80.5,"historia", Set.of(1L,2L,3L));

        PersonajeDTO response = service.updatePersonaje(1L,personaje);

        assertThat(response).isNotNull();
        assertThat(response.getNombre()).isEqualTo("nombre");
        assertThat(response.getEdad()).isEqualTo(65);
        assertThat(response.getHistoria()).isEqualTo("historia");
        assertThat(response.getPeso()).isEqualTo(80.5);
        assertThat(response.getPeliculas()).isNotNull();
    }

    @Test
    void updatePersonaje_invalidId() throws NullEntityException {

        PersonajeRE personaje = new PersonajeRE("nombre",65,80.5,"historia", Set.of(1L,2L,3L));

        assertThrowsExactly(NullEntityException.class, () -> service.updatePersonaje(65L,personaje));
    }

    @Test
    void updatePersonaje_personajeNulo() throws NullEntityException {

        PersonajeRE personaje = null;

        assertThrowsExactly(NullEntityException.class, () -> service.updatePersonaje(1L,personaje));

    }
}