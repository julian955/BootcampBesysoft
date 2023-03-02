package com.bootcamp.besysoft.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeliculaDTO {

    private Long id;

    private String titulo;

    private LocalDate estreno;

    private Integer calificacion;

    private String nombreGenero;

    private List<PersonajeBasicDTO> personajes;

}
