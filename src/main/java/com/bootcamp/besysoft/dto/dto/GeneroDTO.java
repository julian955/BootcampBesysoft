package com.bootcamp.besysoft.dto.dto;

import com.bootcamp.besysoft.dominio.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneroDTO {

    private Long id;

    @NotNull
    @Pattern(regexp = "^[A-Za-z]+$", message = "solamente permite caracteres de la A - Z")
    private String nombre;

    private List<PeliculaBasicDTO> peliculas;

}
