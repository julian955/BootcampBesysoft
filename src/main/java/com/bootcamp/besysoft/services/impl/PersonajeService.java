package com.bootcamp.besysoft.services.impl;


import com.bootcamp.besysoft.dominio.Personaje;
import com.bootcamp.besysoft.repositories.memory.PersonajeRepository;
import com.bootcamp.besysoft.services.interfaces.entity.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService implements IPersonajeService {

    @Autowired
   private PersonajeRepository repository;

    @Override
    public Personaje findByName(String name){

        Optional<Personaje> personaje = repository.findByName(name);

        if (personaje.isEmpty()){
            return null;
        }

       return personaje.get();
    }

    @Override
    public List<Personaje> findAllPersonaje(){

        List<Personaje> list = repository.getAll();

        if (list.isEmpty()){
            return null;
        }

        return list;
    }

    @Override
    public List<Personaje> findPersonajeByEdad(Integer edad){

        List<Personaje> response = repository.getAll().stream()
                .filter(p -> p.getEdad().equals(edad)).toList();

        if (response.isEmpty()){
            return null;
        }

        return response;
    }

    @Override
    public List<Personaje> findPersonajeBetweenEdad(Integer desde,Integer hasta){

        List<Personaje> response = repository.getAll().stream()
                .filter(p -> p.getEdad() >= desde)
                .filter(p -> p.getEdad() <= hasta).toList();

        if (response.isEmpty()){
            return null;
        }

        return response;
    }

    @Override
    public Personaje generatePersonaje(Personaje personaje){

        if (personaje == null){
            return null;
        }

        if (!this.validarNombre(personaje.getNombre())){
            return null;
        }

        personaje.setId((long) (repository.getAll().size()+1));

       Personaje response = repository.save(personaje);

        return response;
    }

    @Override
    public Personaje updatePersonaje(Long id,Personaje personaje){



        Optional<Personaje> pers = repository.findById(id);

        if (pers.isEmpty()){
            return null;
        }

        Personaje response = pers.get();

        if (personaje.getNombre() != null){
            response.setNombre(personaje.getNombre());
        }
        if (personaje.getEdad() != null){
            response.setEdad(personaje.getEdad());
        }
        if (personaje.getPeso() != null){
            response.setPeso(personaje.getPeso());
        }
        if (personaje.getHistoria() != null){
            response.setHistoria(personaje.getHistoria());
        }
        if (personaje.getPeliculas() != null){
            response.setPeliculas(personaje.getPeliculas());
        }

        repository.save(response);

        return response;
    }

    private Boolean validarNombre(String nombre){

        List<Personaje> list = repository.getAll();

        Optional<Personaje> response = list.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).findAny();

        return response.isEmpty();
    }


}
