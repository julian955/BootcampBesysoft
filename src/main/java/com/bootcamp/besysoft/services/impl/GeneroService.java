package com.bootcamp.besysoft.services.impl;

import com.bootcamp.besysoft.dominio.Genero;
import com.bootcamp.besysoft.repositories.memory.GeneroRepository;
import com.bootcamp.besysoft.services.interfaces.entity.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService implements IGeneroService {

   @Autowired
   private GeneroRepository  repository;

    @Override
    public List<Genero> getAllGenero(){
        List<Genero> list = repository.getAll();
        if (list.isEmpty()){
            return null;
        }
        return list;
    }

    @Override
    public Genero createGenero(Genero genero){

        if (genero == null){
            return null;
        }

        if (!this.validarNombre(genero.getNombre())){
            return null;
        }
        genero.setId((long) (repository.getAll().size()+1));
        repository.addGenero(genero);

        return genero;
    }

    @Override
    public Genero updateGenero(Long id,Genero genero){

        Optional<Genero> response = repository.findById(id);

        if (response.isEmpty()){
            return null;
        }

        if (genero.getNombre() != null){
            response.get().setNombre(genero.getNombre());
        }
        if (genero.getPeliculas() != null){
            response.get().setPeliculas(genero.getPeliculas());
        }

        return response.get();
    }

    private Boolean validarNombre(String nombre){

        List<Genero> list = repository.getAll();

        Optional<Genero> response = list.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).findAny();

        return response.isEmpty();
    }
}
