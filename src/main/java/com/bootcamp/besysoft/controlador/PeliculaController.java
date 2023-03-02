package com.bootcamp.besysoft.controlador;

import com.bootcamp.besysoft.dto.dto.PeliculaDTO;
import com.bootcamp.besysoft.dto.requestEntity.PeliculaRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;
import com.bootcamp.besysoft.services.interfaces.dto.IPeliculaServiceDTO;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

import java.util.List;


@RestController
@RequestMapping("/peliculas")
@Slf4j
public class PeliculaController {

    @Autowired
    private IPeliculaServiceDTO service;



    @ApiOperation(value = "Obtener Peliculas",
            notes = "Se obtienen todas las peliculas guardados."
    )
    @ApiResponse(responseCode = "200",
            description = "Retorna una lista con las peliculas.",
            content = {@Content(mediaType = "application/json")}
    )
    @GetMapping()
    public ResponseEntity<?> getAllPeliculas(){

        return ResponseEntity.ok().body(service.findAllPelicula());
    }

    @ApiOperation(
            value = "Buscar por titulo",
            notes = "Se busca una pelicula por titulo",
            nickname = "Buscar por titulo")
    @Parameters({
            @Parameter(
                    name = "title",
                    description = "titulo a buscar",
                    required = true,
                    schema = @Schema(type = "String"),
                    example = "Avatar",
                    in = ParameterIn.PATH)

    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna la pelicula encontrada"),
            @ApiResponse(responseCode = "400", description = "Pelicula no existente")
    })
    @GetMapping("/titulo/{title}")
    public ResponseEntity<?> findPeliculaByTitle(@Valid @PathVariable(value="title") String title) throws NullEntityException {

        PeliculaDTO response = service.findByTitle(title);

        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(
            value = "Buscar por genero",
            notes = "Se busca peliculas por genero",
            nickname = "Buscar por genero")
    @Parameters({
            @Parameter(
                    name = "genero",
                    description = "genero a buscar",
                    required = true,
                    schema = @Schema(type = "String"),
                    example = "Terror",
                    in = ParameterIn.PATH)

    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna una lista con las peliculas encontrada"),
            @ApiResponse(responseCode = "400", description = "Pelicula no existente")
    })
    @GetMapping("/genero/{genero}")
    public ResponseEntity<?> findPeliculaByGenero(@Valid @PathVariable(value="genero") String genero) throws NullEntityException {

        List<PeliculaDTO> response = service.findPeliculaByGenero(genero);

        return ResponseEntity.ok().body(response);
    }


    @ApiOperation(
            value = "Buscar peliculas entre dos fechas",
            notes = "Se busca peliculas entre dos fechas",
            nickname = "Buscar por fechas")
    @Parameters({
            @Parameter(
                    name = "desde",
                    description = "techa desde donde queremos buscar",
                    required = true,
                    schema = @Schema(type = "LocalDate"),
                    example = "02012020"),
            @Parameter(
                    name = "hasta",
                    description = "fecha hasta donde queremos buscar",
                    required = true,
                    schema = @Schema(type = "LocalDate"),
                    example = "02012022")

    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna una lista con las peliculas encontrada"),
            @ApiResponse(responseCode = "400", description = "Peliculas no existente")
    })
    @GetMapping("/fechas")
    public ResponseEntity<?> findPeliculaByDates(@Valid @RequestParam(value="desde") @DateTimeFormat(pattern = "ddMMyyyy") LocalDate desde,
                                               @RequestParam(value="hasta") @DateTimeFormat(pattern = "ddMMyyyy") LocalDate hasta) throws NullEntityException {


        List<PeliculaDTO> response = service.findPeliculaBetweenDates(desde,hasta);

        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(
            value = "Buscar peliculas entre dos calificaciones",
            notes = "Se busca peliculas entre dos calificaciones",
            nickname = "Buscar por calificacion")
    @Parameters({
            @Parameter(
                    name = "desde",
                    description = "calificacion desde donde queremos buscar",
                    required = true,
                    schema = @Schema(type = "Integer"),
                    example = "1"),
            @Parameter(
                    name = "hasta",
                    description = "calificacion hasta donde queremos buscar",
                    required = true,
                    schema = @Schema(type = "Integer"),
                    example = "3")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna una lista con las peliculas encontrada"),
            @ApiResponse(responseCode = "400", description = "Peliculas no existente")
    })
    @GetMapping("/calificacion")
    public ResponseEntity<?> findPeliculaByCalification(@Valid @RequestParam(value="desde")  Integer desde,
                                                      @RequestParam(value="hasta")  Integer hasta) throws NullEntityException {


        List<PeliculaDTO> response = service.findPeliculaBetweenCalification(desde,hasta);

        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(
            value = "Crear una pelicula",
            notes = "Se crea una nueva pelicula",
            nickname = "Crear pelicula")
    @Parameter(
            name = "pelicula",
            description = "Pelicula nueva",
            required = true,
            schema = @Schema(type = "PeliculaRE"))
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "la Pelicula Fue Creada Correctamente"),
            @ApiResponse(responseCode = "400", description = "Pelicula nula / El nombre ya existe")
    })
    @PostMapping("")
    public ResponseEntity<?> generatePelicula(@Valid @RequestBody PeliculaRE pelicula) throws InvalidNameException, NullEntityException {

        PeliculaDTO response = service.generatePelicula(pelicula);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @ApiOperation(
            value = "Actualizar una pelicula",
            notes = "Se actualiza una pelicula existente",
            nickname = "Actualizar Pelicula")
    @Parameters({
            @Parameter(
                    name = "id",
                    description = "pelicula a actualizar",
                    required = true,
                    schema = @Schema(type = "Long"),
                    example = "1",
                    in = ParameterIn.PATH),
            @Parameter(name = "pelicula",
                    required = true,
                    schema = @Schema(type = "PeliculaRE"))
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "La Pelicula Fue Actualizada Correctamente"),
            @ApiResponse(responseCode = "400", description = "Pelicula nula / Id invalido /El nombre ya existe")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePelicula(@Valid  @PathVariable(value = "id") Long id,
                                            @RequestBody PeliculaRE pelicula) throws NullEntityException {

        PeliculaDTO response = service.updatePelicula(id,pelicula);

        return ResponseEntity.ok().body(response);

    }


}
