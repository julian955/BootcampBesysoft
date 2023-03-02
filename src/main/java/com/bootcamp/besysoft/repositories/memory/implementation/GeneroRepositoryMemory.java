package com.bootcamp.besysoft.repositories.memory.implementation;

import com.bootcamp.besysoft.dominio.Genero;
import com.bootcamp.besysoft.dominio.Pelicula;
import com.bootcamp.besysoft.repositories.memory.GeneroRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class GeneroRepositoryMemory implements GeneroRepository {

    private List<Genero> generoList;

    public GeneroRepositoryMemory(){
        ArrayList<Pelicula> peli1 = new ArrayList<>();
        peli1.add(new Pelicula(1L,"Black Adam", LocalDate.of(2022,02,22),4,null));
        peli1.add(new Pelicula(2L,"La ciudad perdida", LocalDate.of(2022,04,20),4,null));
        peli1.add(new Pelicula(3L,"El hombre del norte", LocalDate.of(2022,05,29),4,null));

        ArrayList<Pelicula> peli2 = new ArrayList<>();
        peli2.add(new Pelicula(1L,"La luz del diablo", LocalDate.of(2022,02,22),4,null));
        peli2.add(new Pelicula(2L,"La Monja", LocalDate.of(2018,04,20),4,null));
        peli2.add(new Pelicula(3L,"La Huérfana: el origen", LocalDate.of(2022,05,29),4,null));

        ArrayList<Pelicula> peli3 = new ArrayList<>();
        peli3.add(new Pelicula(1L,"Cielo de medianoche", LocalDate.of(2020,02,22),4,null));
        peli3.add(new Pelicula(2L,"Guasón", LocalDate.of(2019,04,20),4,null));
        peli3.add(new Pelicula(3L,"A la deriva", LocalDate.of(2018,05,29),4,null));

        ArrayList<Pelicula> peli4 = new ArrayList<>();
        peli4.add(new Pelicula(1L,"Gato con Botas", LocalDate.of(2011,02,22),4,null));
        peli4.add(new Pelicula(2L,"Misterio a bordo", LocalDate.of(2019,04,20),4,null));
        peli4.add(new Pelicula(3L,"Shrek", LocalDate.of(2001,05,29),4,null));

        ArrayList<Pelicula> peli5 = new ArrayList<>();
        peli5.add(new Pelicula(1L,"Interestelar", LocalDate.of(2014,02,22),4,null));
        peli5.add(new Pelicula(2L,"Moonfall", LocalDate.of(2022,04,20),4,null));
        peli5.add(new Pelicula(3L,"Avatar", LocalDate.of(2009,05,29),4,null));

        this.generoList = new ArrayList<>(
                Arrays.asList(
                        new Genero(1L,"Aventura",peli1),
                        new Genero(2L,"Terror",peli2),
                        new Genero(3L,"Drama",peli3),
                        new Genero(4L,"Comedia",peli4),
                        new Genero(5L,"Ciencia Ficcion",peli5)
                )
        );
    }

    @Override
    public List<Genero> getAll(){
        return this.generoList;
    }

    @Override
    public Genero addGenero(Genero genero){
        this.generoList.add(genero);
        return genero;
    }

    @Override
    public Optional<Genero> findById(Long id){
        Optional<Genero> genero = this.generoList.stream().filter(x -> x.getId().equals(id)).findFirst();
        return genero;
    }

    @Override
    public List<Pelicula> getPeliculaByGenero(String genero){
        Optional<Genero> gen = this.generoList.stream().filter(p -> p.getNombre().equalsIgnoreCase(genero)).findFirst();
        return gen.get().getPeliculas();
    }
}
