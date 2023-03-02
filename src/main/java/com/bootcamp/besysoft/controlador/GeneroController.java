package com.bootcamp.besysoft.controlador;


import com.bootcamp.besysoft.dto.dto.GeneroDTO;
import com.bootcamp.besysoft.dto.requestEntity.GeneroRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;
import com.bootcamp.besysoft.services.interfaces.dto.IGeneroServiceDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/generos")
@Slf4j
public class GeneroController {


    @Autowired
    private IGeneroServiceDTO service;


    @ApiOperation(value = "Obtener Generos",
            notes = "Se obtienen todos los generos guardados."
    )
    @ApiResponse(responseCode = "200",
            description = "Retorna una lista con los  generos.",
            content = {@Content(mediaType = "application/json")}
    )
    @GetMapping()
    public ResponseEntity<?> getAllGenero(){
        return ResponseEntity.ok().body(service.getAllGenero());
    }



    @ApiOperation(
            value = "Crear un genero",
            notes = "Se crea un nuevo genero",
            nickname = "Crear Genero")

    @Parameter(name = "genero",
            required = true,
            schema = @Schema(type = "GeneroRE"))

    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "El Genero Fue Creado Correctamente"),
            @ApiResponse(responseCode = "400", description = "Genero nulo / El nombre ya existe")
    })
    @PostMapping()
    public ResponseEntity<?> createGenero(@Valid @RequestBody GeneroRE genero) throws InvalidNameException, NullEntityException {

       GeneroDTO response = service.createGenero(genero);

       return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(
            value = "Actualizar un genero",
            notes = "Se actualiza un genero existente",
            nickname = "Actualizar Genero")
    @Parameters({
            @Parameter(
                    name = "id",
                    description = "Personaje a actualizar",
                    required = true,
                    schema = @Schema(type = "Long"),
                    example = "1",
                    in = ParameterIn.PATH),
            @Parameter(
                    name = "genero",
                    required = true,
                    schema = @Schema(type = "GeneroRE"))
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "El Genero Fue Actualizado Correctamente"),
            @ApiResponse(responseCode = "400", description = "Genero nulo / Id invalido / El nombre ya existe")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGenero(@Valid @PathVariable Long id, @RequestBody GeneroRE genero) throws NullEntityException {

        return ResponseEntity.ok().body(service.updateGenero(id,genero));
    }
}
