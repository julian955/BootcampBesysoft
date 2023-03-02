package com.bootcamp.besysoft.controlador;



import com.bootcamp.besysoft.dto.dto.PersonajeDTO;
import com.bootcamp.besysoft.dto.requestEntity.PersonajeRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;
import com.bootcamp.besysoft.services.interfaces.dto.IPersonajeServiceDTO;
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

import java.util.List;


@RestController
@RequestMapping("/personajes")
@Slf4j
public class PersonajeController {

    @Autowired
    private IPersonajeServiceDTO service;



    @ApiOperation(value = "Obtener Personajes",
            notes = "Se obtienen todos los personajes guardados."
    )
    @ApiResponse(responseCode = "200",
            description = "Retorna una lista con los personajes.",
            content = {@Content(mediaType = "application/json")}
    )
    @GetMapping
    public ResponseEntity<?> getAllPersonajes(){
        return ResponseEntity.ok().body( service.findAllPersonaje());
    }


    @ApiOperation(
            value = "Buscar por nombre",
            notes = "Se busca un personajes por nombre",
            nickname = "Buscar por nombre")
    @Parameters({
            @Parameter(
                    name = "name",
                    description = "nombre a buscar",
                    required = true,
                    schema = @Schema(type = "String"),
                    example = "Adam Sandler",
                    in = ParameterIn.PATH)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna el personaje encontrado"),
            @ApiResponse(responseCode = "400", description = "Personaje no existente")
    })
    @GetMapping("/nombre/{name}")
    public ResponseEntity<?> findPersonajeByName(@Valid  @PathVariable(value="name") String name) throws NullEntityException {

        return ResponseEntity.ok().body(service.findByName(name));
    }

    @ApiOperation(
            value = "Buscar por edad",
            notes = "Se busca personajes por edad",
            nickname = "Buscar por edad")
    @Parameters({
            @Parameter(
                    name = "edad",
                    description = "edad que queremos buscar",
                    required = true,
                    schema = @Schema(type = "Integer"),
                    example = "30",
                    in = ParameterIn.PATH)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna los personajes encontrado"),
            @ApiResponse(responseCode = "400", description = "Personaje no existente")
    })
    @GetMapping("/edad/{edad}")
    public ResponseEntity<?> findPersonajeByEdad(@Valid @PathVariable(value="edad") Integer edad) throws NullEntityException {

        List<PersonajeDTO> response = service.findPersonajeByEdad(edad);

        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(
            value = "Buscar entre edades",
            notes = "Se busca personajes entre dos edades",
            nickname = "Buscar entre edades")
    @Parameters({
            @Parameter(
                    name = "desde",
                    description = "edad desde donde queremos buscar",
                    required = true,
                    schema = @Schema(type = "Integer"),
                    example = "30"),
            @Parameter(
                    name = "hasta",
                    description = "edad hasta donde queremos buscar",
                    required = true,
                    schema = @Schema(type = "Integer"),
                    example = "50")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna los personajes encontrado"),
            @ApiResponse(responseCode = "400", description = "Personaje no existente")
    })
    @GetMapping("/edad")
    public ResponseEntity<?> findPersonajeBetweenEdad(@Valid @RequestParam(value="desde")  Integer desde,
                                                    @RequestParam(value="hasta")  Integer hasta) throws NullEntityException {

        List<PersonajeDTO> response = service.findPersonajeBetweenEdad(desde,hasta);

        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(
            value = "Crear un personaje",
            notes = "Se crea un nuevo personaje",
            nickname = "Crear personaje")
    @Parameter(
            name = "personaje",
            description = "Personaje nuevo",
            required = true,
            schema = @Schema(type = "PersonajeRE"))
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "el Personaje Fue Creado Correctamente"),
            @ApiResponse(responseCode = "400", description = "Personaje nulo / El nombre ya existe")
    })
    @PostMapping()
    public ResponseEntity<?> createPersonaje(@Valid @RequestBody PersonajeRE personaje) throws InvalidNameException, NullEntityException {

        PersonajeDTO response = service.generatePersonaje(personaje);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(
            value = "Actualizar un personaje",
            notes = "Se actualiza un personaje existente",
            nickname = "Actualizar Personaje")
    @Parameters({
            @Parameter(
                    name = "id",
                    description = "Personaje a actualizar",
                    required = true,
                    schema = @Schema(type = "Long"),
                    example = "1",
                    in = ParameterIn.PATH),
            @Parameter(
                    name = "personaje",
                    description = "Personaje actualizado",
                    required = true,
                    schema = @Schema(type = "PersonajeRE"))
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "el Personaje Fue Actualizado Correctamente"),
            @ApiResponse(responseCode = "400", description = "Personaje nulo / Id invalido / El nombre ya existe")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonaje(@Valid @PathVariable(value = "id") Long id,
                                             @RequestBody PersonajeRE personaje) throws NullEntityException {

        PersonajeDTO response = service.updatePersonaje(id,personaje);

        return ResponseEntity.ok().body(response);
    }
}
