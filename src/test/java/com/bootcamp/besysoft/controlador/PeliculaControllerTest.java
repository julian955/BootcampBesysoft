package com.bootcamp.besysoft.controlador;

import com.bootcamp.besysoft.dto.dto.PeliculaDTO;
import com.bootcamp.besysoft.dto.requestEntity.PeliculaRE;
import com.bootcamp.besysoft.services.interfaces.dto.IPeliculaServiceDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(PeliculaController.class)
class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPeliculaServiceDTO service;

    private ObjectMapper objectMapper;
    private String url;

    @BeforeEach
    void setUp() {
        this.url = "/peliculas";
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void getAllPeliculas() throws Exception {
        List<PeliculaDTO> list = Arrays.asList(new PeliculaDTO(1L,"titulo",null,4,"terror",null),
                new PeliculaDTO(2L,"titulo1",null,4,"terror",null),
                new PeliculaDTO(3L,"titulo2",null,4,"terror",null),
                new PeliculaDTO(4L,"titulo3",null,4,"terror",null));

        when(service.findAllPelicula()).thenReturn(list);

        mockMvc.perform(
                        get(url)
                                .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());

    }

    @Test
    void findPeliculaByTitle() throws Exception {
        String title = "titulo";
        PeliculaDTO pelicula = new PeliculaDTO(1L,"titulo",null,4,"terror",null);

        when(service.findByTitle(title)).thenReturn(pelicula);

        mockMvc.perform(
                        get(url+"/titulo/{title}","titulo")
                                .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    void findPeliculaByGenero() throws Exception {
        List<PeliculaDTO> list = Arrays.asList(new PeliculaDTO(1L,"titulo",null,4,"terror",null),
                new PeliculaDTO(2L,"titulo1",null,4,"terror",null),
                new PeliculaDTO(3L,"titulo2",null,4,"terror",null),
                new PeliculaDTO(4L,"titulo3",null,4,"terror",null));

        when(service.findPeliculaByGenero("terror")).thenReturn(list);

        mockMvc.perform(
                        get(url+"/genero/{genero}","terror")
                                .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    void findPeliculaByDates() throws Exception {
        LocalDate date1 = LocalDate.of(2008,05,20);
        LocalDate date2 = LocalDate.of(2012,05,20);

        List<PeliculaDTO> list = Arrays.asList(new PeliculaDTO(1L,"titulo",LocalDate.of(2008,05,20),4,"terror",null),
                new PeliculaDTO(2L,"titulo1",LocalDate.of(2009,10,20),4,"terror",null),
                new PeliculaDTO(3L,"titulo2",LocalDate.of(2010,05,20),4,"terror",null),
                new PeliculaDTO(4L,"titulo3",LocalDate.of(2011,07,20),4,"terror",null));

        when(service.findPeliculaBetweenDates(date1,date2)).thenReturn(list);

        mockMvc.perform(
                        get(url+"/fechas")
                                .param("desde","20052008")
                                .param("hasta","20052012")
                                .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    void findPeliculaByCalification() throws Exception {
        Integer cal1 = 1;
        Integer cal2 = 3;

        List<PeliculaDTO> list = Arrays.asList(new PeliculaDTO(1L,"titulo",LocalDate.of(2008,05,20),1,"terror",null),
                new PeliculaDTO(2L,"titulo1",LocalDate.of(2009,10,20),2,"terror",null),
                new PeliculaDTO(3L,"titulo2",LocalDate.of(2010,05,20),3,"terror",null),
                new PeliculaDTO(4L,"titulo3",LocalDate.of(2011,07,20),3,"terror",null));

        when(service.findPeliculaBetweenCalification(cal1,cal2)).thenReturn(list);

        mockMvc.perform(
                        get(url+"/calificacion")
                                .param("desde","1")
                                .param("hasta","3")
                                .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    void generatePelicula() throws Exception {

        PeliculaRE peliculaRE = new PeliculaRE("Titulo",null,4,1L,null);
        PeliculaDTO peliculaDTO = new PeliculaDTO(1L,"Titulo",null,4,"Terror",null);

        when(service.generatePelicula(peliculaRE)).thenReturn(peliculaDTO);

        mockMvc.perform(
                        post(url)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(peliculaRE))
                )

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    void updatePelicula() throws Exception {

        PeliculaRE peliculaRE = new PeliculaRE("Titulo Actualizado",null,4,1L,null);
        PeliculaDTO peliculaDTO = new PeliculaDTO(1L,"Titulo Actualizado",null,4,"Terror",null);


        when(service.updatePelicula(1L,peliculaRE)).thenReturn(peliculaDTO);

        mockMvc.perform(
                        put(url+"/{id}",1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(peliculaRE))
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }
}