package com.bootcamp.besysoft.controlador;

import com.bootcamp.besysoft.dto.dto.PersonajeDTO;
import com.bootcamp.besysoft.dto.requestEntity.PersonajeRE;
import com.bootcamp.besysoft.services.interfaces.dto.IPersonajeServiceDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(PersonajeController.class)
class PersonajeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPersonajeServiceDTO service;

    private ObjectMapper objectMapper;
    private String url;

    @BeforeEach
    void setUp() {
        this.url = "/personajes";
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void getAllPersonajes() throws Exception {
        List<PersonajeDTO> list = Arrays.asList(new PersonajeDTO(1L,"nombre",45,80.5,"historia",null),
                new PersonajeDTO(2L,"nombre1",45,80.5,"historia",null),
                new PersonajeDTO(3L,"nombre2",55,80.5,"historia",null),
                new PersonajeDTO(4L,"nombre3",65,80.5,"historia",null));

        when(service.findAllPersonaje()).thenReturn(list);

        mockMvc.perform(
                        get(url)
                                .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());

    }

    @Test
    void findPersonajeByName() throws Exception {
        PersonajeDTO personaje = new PersonajeDTO(1L,"nombre",45,80.5,"historia",null);

        when(service.findByName("nombre")).thenReturn(personaje);

        mockMvc.perform(
                        get(url+"/nombre/{name}","nombre")
                                .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());

    }

    @Test
    void findPersonajeByEdad() throws Exception {
        List<PersonajeDTO> list = Arrays.asList(new PersonajeDTO(1L,"nombre",45,80.5,"historia",null),
                new PersonajeDTO(4L,"nombre3",45,80.5,"historia",null));

        when(service.findPersonajeByEdad(45)).thenReturn(list);

        mockMvc.perform(
                        get(url+"/edad/{edad}",45)
                                .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    void findPersonajeBetweenEdad() throws Exception {

        List<PersonajeDTO> list = Arrays.asList(new PersonajeDTO(1L,"nombre",45,80.5,"historia",null),
                new PersonajeDTO(2L,"nombre1",45,80.5,"historia",null),
                new PersonajeDTO(3L,"nombre2",55,80.5,"historia",null),
                new PersonajeDTO(4L,"nombre3",65,80.5,"historia",null));


        when(service.findPersonajeBetweenEdad(45,65)).thenReturn(list);

        mockMvc.perform(
                        get(url+"/edad")
                                .param("desde","45")
                                .param("hasta","65")
                                .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    void createPersonaje() throws Exception {
        PersonajeRE personajeRE = new PersonajeRE("Nombre",50,75.3,"historia",null);
        PersonajeDTO personajeDTO = new PersonajeDTO(1L,"nombre",50,75.3,"hisotoria",null);

        when(service.generatePersonaje(personajeRE)).thenReturn(personajeDTO);

        mockMvc.perform(
                        post(url)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(personajeRE))
                )

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());


    }

    @Test
    void updatePersonaje() throws Exception {
            PersonajeRE personajeRE = new PersonajeRE("Nombre",50,75.3,"historia",null);
            PersonajeDTO personajeDTO = new PersonajeDTO(1L,"nombre",50,75.3,"hisotoria",null);

            when(service.updatePersonaje(1L,personajeRE)).thenReturn(personajeDTO);

            mockMvc.perform(
                            put(url+"/{id}",1)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(this.objectMapper.writeValueAsString(personajeRE))
                    )

                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }
}