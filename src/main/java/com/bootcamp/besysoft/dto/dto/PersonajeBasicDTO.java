package com.bootcamp.besysoft.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonajeBasicDTO {

    private Long id;

    private String nombre;
}
