package com.bootcamp.besysoft.dto.requestEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeliculaRE {

    @NotBlank
    private String titulo;

    private LocalDate estreno;

    private Integer calificacion;

    private Long generoId;

    private Set<Long> personajesId;
}
