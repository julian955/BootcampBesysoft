package com.bootcamp.besysoft.services.impJPA;

import com.bootcamp.besysoft.dominio.Genero;


import com.bootcamp.besysoft.dto.dto.GeneroDTO;
import com.bootcamp.besysoft.dto.mapper.GeneroMapper;
import com.bootcamp.besysoft.dto.requestEntity.GeneroRE;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;
import com.bootcamp.besysoft.repositories.database.GeneroRepositoryJPA;
import com.bootcamp.besysoft.repositories.database.PeliculaRepositoryJPA;
import com.bootcamp.besysoft.services.interfaces.dto.IGeneroServiceDTO;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Primary
@AllArgsConstructor
public class GeneroServiceJPA implements IGeneroServiceDTO {


    private final GeneroRepositoryJPA repository;

    private PeliculaRepositoryJPA peliculaRepositoryJPA;

    private GeneroMapper generoMapper;

    @Override
    @Transactional
    public List<GeneroDTO> getAllGenero() {

        List<Genero> list = repository.findAll();
        return generoMapper.listToDTO(list);
    }

    @Override
    public GeneroDTO createGenero(GeneroRE genero) throws NullEntityException, InvalidNameException {

        if (genero == null){
            throw new NullEntityException("No se puede crear un genero nulo.");
        }

        if (this.validarNombre(genero.getNombre())){
            throw new InvalidNameException("El nombre ingresado ya existe.");
        }

        Genero entity = generoMapper.mapREToEntity(genero);

        repository.save(entity);

        return generoMapper.mapToDTO(entity);
    }

    @Override
    public GeneroDTO updateGenero(Long id, GeneroRE genero) throws NullEntityException {
        Optional<Genero> optGenero = repository.findById(id);
        if (optGenero.isEmpty()){
            throw new NullEntityException("No se encontro el genero con el id ingresado.");
        }

        Genero response = optGenero.get();
        if (genero.getNombre() != null){
            response.setNombre(genero.getNombre());
        }

        repository.save(response);
        return generoMapper.mapToDTO(response);
    }

    private Boolean validarNombre(String nombre){

        Optional<Genero> response = repository.findByNombreIgnoreCase(nombre);

        return response.isPresent();
    }

}
