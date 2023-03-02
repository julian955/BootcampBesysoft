package com.bootcamp.besysoft.repositories.memory.implementation;

import com.bootcamp.besysoft.dominio.Pelicula;
import com.bootcamp.besysoft.dominio.Personaje;
import com.bootcamp.besysoft.repositories.memory.PersonajeRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonajeRepositoryMemory implements PersonajeRepository {

    private List<Personaje> personajeList;

    public PersonajeRepositoryMemory() {
        ArrayList<Pelicula> ws = new ArrayList<>();
        ws.add(new Pelicula(1L, "Hancock", LocalDate.of(2008, 04, 05), 4, null));
        ws.add(new Pelicula(2L, "Focus", LocalDate.of(2015, 03, 12), 5, null));
        ws.add(new Pelicula(3L, "Proyecto géminis", LocalDate.of(2019, 06, 23), 4, null));

        ArrayList<Pelicula> as = new ArrayList<>();
        as.add(new Pelicula(1L, "Pixels", LocalDate.of(2015, 02, 18), 4, null));
        as.add(new Pelicula(2L, "Hotel Transylvania 3: Summer Vacation", LocalDate.of(2018, 06, 29), 4, null));
        as.add(new Pelicula(3L, "El Halloween de Hubie", LocalDate.of(2020, 07, 12), 4, null));

        ArrayList<Pelicula> jd = new ArrayList<>();
        jd.add(new Pelicula(1L, "Pirates of the Caribbean: The Curse of the Black Pearl", LocalDate.of(2003, 03, 12), 4, null));
        jd.add(new Pelicula(2L, "Charlie y la fábrica de chocolate", LocalDate.of(2005, 07, 23), 4, null));
        jd.add(new Pelicula(3L, "Animales fantásticos: los crímenes de Grindelwald", LocalDate.of(2018, 06, 14), 4, null));

        ArrayList<Pelicula> dj = new ArrayList<>();
        dj.add(new Pelicula(1L, "Baywatch", LocalDate.of(2017, 03, 12), 4, null));
        dj.add(new Pelicula(2L, "Rascacielos: Rescate en las alturas", LocalDate.of(2018, 06, 19), 4, null));
        dj.add(new Pelicula(3L, "Black Adam", LocalDate.of(2022, 02, 22), 4, null));

        ArrayList<Pelicula> kr = new ArrayList<>();
        kr.add(new Pelicula(1L, "Matrix", LocalDate.of(1999, 03, 12), 4, null));
        kr.add(new Pelicula(2L, "John Wick", LocalDate.of(2014, 04, 20), 4, null));
        kr.add(new Pelicula(3L, "Quizás para siempre", LocalDate.of(2019, 05, 29), 4, null));


        personajeList = new ArrayList<>(Arrays.asList(
                new Personaje(1L, "Will Smith", 54, 75.0, "actor, rapero, productor cinematográfico, productor discográfico, guionista, empresario y filántropo estadounidense. Ha tenido éxito en sus dos facetas artísticas:5\u200B siendo ganador de un Premio Óscar con dos nominaciones previas, nominado a cuatro Premios Globo de Oro y ha ganado cuatro Premios Grammy.", ws),
                new Personaje(2L, "Adam Sandler", 56, 82.0, "comediante, actor, escritor, y productor estadounidense. Después de convertirse en miembro del elenco de Saturday Night Live, ha protagonizado una gran cantidad de películas de Hollywood que han recaudado cerca de dos mil millones de dólares de taquilla.", as),
                new Personaje(3L, "Johnny Depp", 59, 70.0, "actor, productor de cine y músico estadounidense. Ha sido nominado en tres ocasiones al Óscar y recibió un Globo de Oro,1\u200B un premio del Sindicato de Actores y un César", jd),
                new Personaje(4L, "Dwayne Johnson", 50, 85.0, " actor y luchador profesional estadounidense.1\u200B Se desempeñó como luchador profesional para la WWE hasta su retirada oficial en 2019,2\u200B con el objetivo de centrarse en su carrera artística. Ha participado en una gran diversidad de películas siendo premiado en bastantes de ellas", dj),
                new Personaje(5L, "Keanu Reeves", 58, 72.0, "actor y músico canadiense.3\u200BEs conocido por Interpretar a Neo en \"Matrix\" y a John Wick En la trilogía \"John Wick\". Tiene sangre china por parte de su abuela.", kr)

        ));
    }

    @Override
    public List<Personaje> getAll(){
        return this.personajeList;
    }

    @Override
    public Optional<Personaje> findById(Long id) {
        Optional<Personaje> personaje = this.personajeList.stream().
                filter(p -> p.getId().equals(id)).findAny();

        return personaje;
    }

    @Override
    public Optional<Personaje> findByName(String name){
        Optional<Personaje> personaje = this.personajeList.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(name)).findFirst();
        return personaje;
    }

    @Override
    public Personaje save(Personaje personaje){
        this.personajeList.add(personaje);
        return personaje;
    }
}
