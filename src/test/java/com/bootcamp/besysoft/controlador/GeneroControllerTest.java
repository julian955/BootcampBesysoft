package com.bootcamp.besysoft.controlador;

import com.bootcamp.besysoft.dominio.Genero;
import com.bootcamp.besysoft.dto.dto.GeneroDTO;
import com.bootcamp.besysoft.dto.mapper.GeneroMapper;
import com.bootcamp.besysoft.dto.requestEntity.GeneroRE;

import com.bootcamp.besysoft.services.interfaces.dto.IGeneroServiceDTO;
import com.bootcamp.besysoft.utilidades.Dummy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.MimeTypeUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(GeneroController.class)
class GeneroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IGeneroServiceDTO service;


    private ObjectMapper objectMapper;
    private String url;

    @BeforeEach
    void setUp() {
        this.url = "/generos";
        this.objectMapper = new ObjectMapper();
    }



    @Test
    void getAllGenero() throws Exception {

        List<GeneroDTO> list = Arrays.asList(new GeneroDTO(1l,"asd",null),
                new GeneroDTO(2l,"asd1",null),
                new GeneroDTO(3l,"asd2",null));

        when(service.getAllGenero())
                .thenReturn(list);

        mockMvc.perform(
                get(url)
                        .contentType(MediaType.APPLICATION_JSON)
        )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());


    }

    @Test
    void createGenero() throws Exception {

        GeneroRE genero = new GeneroRE("Romance");
        GeneroDTO generoDTO = new GeneroDTO(1L,"Romance",null);

        when(service.createGenero(genero)).thenReturn(generoDTO);


        mockMvc.perform(
                        post(url)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(genero))
                )

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    void updateGenero() throws Exception {

        List<GeneroDTO> list = Arrays.asList(new GeneroDTO(1l,"asd",null),
                new GeneroDTO(2l,"asd1",null),
                new GeneroDTO(3l,"asd2",null));


        GeneroRE genero = new GeneroRE("Genero Test");
        GeneroDTO generoDTO = new GeneroDTO(1L,"Genero Test",null);


        when(service.updateGenero(1L,genero)).thenReturn(generoDTO);


        mockMvc.perform(
                        put(url+"/{id}",1L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(genero))
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }

}