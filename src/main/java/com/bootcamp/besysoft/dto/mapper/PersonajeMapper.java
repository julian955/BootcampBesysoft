package com.bootcamp.besysoft.dto.mapper;

import com.bootcamp.besysoft.dominio.Personaje;
import com.bootcamp.besysoft.dto.dto.PersonajeDTO;
import com.bootcamp.besysoft.dto.requestEntity.PersonajeRE;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonajeMapper {

    Personaje mapREToEntity(PersonajeRE dto);

    PersonajeDTO mapToDTO(Personaje entity);

    List<PersonajeDTO> listToDTO(List<Personaje> list);
}
