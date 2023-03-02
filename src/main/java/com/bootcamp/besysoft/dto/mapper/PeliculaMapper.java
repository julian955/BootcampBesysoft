package com.bootcamp.besysoft.dto.mapper;


import com.bootcamp.besysoft.dominio.Genero;
import com.bootcamp.besysoft.dominio.Pelicula;
import com.bootcamp.besysoft.dto.dto.PeliculaDTO;
import com.bootcamp.besysoft.dto.requestEntity.PeliculaRE;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;



import java.util.List;


@Mapper(componentModel = "spring")
public interface PeliculaMapper {

    @Mapping(target = "nombreGenero", source = "genero",qualifiedByName = "nombreGenero")
    PeliculaDTO mapToDTO(Pelicula entity);

    List<PeliculaDTO> listToDTO(List<Pelicula> list);

    Pelicula mapREToEntity(PeliculaRE peliculaRE);

    @Named("nombreGenero")
    static String generoToString(Genero genero){
        return genero.getNombre();
    }
 
}
