package com.bootcamp.besysoft.dto.mapper;

import com.bootcamp.besysoft.dominio.Genero;
import com.bootcamp.besysoft.dto.dto.GeneroDTO;
import com.bootcamp.besysoft.dto.requestEntity.GeneroRE;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface GeneroMapper {

    Genero mapREToEntity(GeneroRE generoRE);

    GeneroDTO mapToDTO(Genero entity);

    List<GeneroDTO> listToDTO(List<Genero> list);

}
