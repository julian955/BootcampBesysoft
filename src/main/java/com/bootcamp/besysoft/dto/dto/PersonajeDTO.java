package com.bootcamp.besysoft.dto.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonajeDTO {

    private Long id;

    private String nombre;

    private Integer edad;

    private Double peso;

    private String historia;

    private List<PeliculaBasicDTO> peliculas;
}
