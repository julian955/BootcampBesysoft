package com.bootcamp.besysoft.dto.requestEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneroRE {

    @NotBlank
    @Pattern(regexp = "^[A-Za-z]+$", message = "solamente permite caracteres de la A - Z")
    private String nombre;
}
