package com.bootcamp.besysoft.services.interfaces.dto;

import com.bootcamp.besysoft.dto.dto.GeneroDTO;
import com.bootcamp.besysoft.dto.requestEntity.GeneroRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;

import java.util.List;

public interface IGeneroServiceDTO {

    List<GeneroDTO> getAllGenero();

    GeneroDTO createGenero(GeneroRE genero) throws NullEntityException, InvalidNameException;

    GeneroDTO updateGenero(Long id,GeneroRE genero) throws NullEntityException;
}
