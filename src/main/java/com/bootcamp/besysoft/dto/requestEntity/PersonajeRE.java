package com.bootcamp.besysoft.dto.requestEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonajeRE {

    @NotBlank
    private String nombre;

    private Integer edad;

    private Double peso;

    private String historia;

    private Set<Long> peliculaId;
}
