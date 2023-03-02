package com.bootcamp.besysoft.repositories.memory.implementation;


import com.bootcamp.besysoft.dominio.Pelicula;
import com.bootcamp.besysoft.dominio.Personaje;
import com.bootcamp.besysoft.repositories.memory.PeliculaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaRepositoryMemory implements PeliculaRepository {

    private List<Pelicula> peliculaList;

    public PeliculaRepositoryMemory(){
        ArrayList<Personaje> batman = new ArrayList<>();
        batman.add(new Personaje(1L,"Robert Pattinson",36,70.0,"Inició su carrera durante su adolescencia como modelo de varias marcas infantiles, pero tras la llegada de su pubertad comenzó a tener problemas para obtener nuevos empleos, por lo que decidió dedicarse a la actuación.",null));
        batman.add(new Personaje(2L,"Zoë Isabella Kravitz",34,55.0,"es una actriz, cantante y modelo estadounidense.3\u200B4\u200B Hija del actor y músico Lenny Kravitz y la actriz Lisa Bonet, hizo su debut como actriz en la película de comedia romántica Sin reservas (2007)",null));
        batman.add(new Personaje(3L,"Jeffrey Wright",57,75.0,"es un actor y productor de cine y televisión estadounidense. Ganador del Globo de Oro al mejor actor de reparto - series, miniserie o telefilme y del Emmy al mejor actor de reparto - miniserie o telefilme; y candidato al Premio del Sindicato de Actores",null));


        ArrayList<Personaje> hdn = new ArrayList<>();
        hdn.add(new Personaje(1L,"Alexander Skarsgård",46,71.0,"Comenzó a actuar a los siete años pero renunció a la edad de trece. Después de servir en el ejército sueco, Skarsgård regresó a la actuación y obtuvo su primer papel en una película estadounidense en la comedia Zoolander (2001) y saltó a la fama al interpretar al vampiro Eric Northman en la serie de televisión True Blood (2008-2014).",null));
        hdn.add(new Personaje(2L,"Nicole Mary Kidman",55,58.0,"es una actriz, productora y cantante australiana-estadounidense.",null));
        hdn.add(new Personaje(3L,"Anya Taylor-Joy",26,53.0," es una actriz y modelo británica-argentina5\u200B nacida en Estados Unidos.6\u200B Ha recibido varios reconocimientos, incluido un Globo de Oro, un Premio del Sindicato de Actores y un Premio de la Crítica Televisiva",null));


        ArrayList<Personaje> tg = new ArrayList<>();
        tg.add(new Personaje(1L,"Tom Cruise",60,76.0,"es un actor y productor de cine estadounidense ganador de tres premios Globo de Oro, un Premio Saturn y una Palma de Oro honoraria. A lo largo de más de cuatro décadas de carrera ha protagonizado, películas de gran éxito comercial que también han sido aclamadas por la crítica.",null));
        tg.add(new Personaje(2L,"Miles Teller",35,83.0,"es un actor estadounidense. Desde joven, mostró interés por la música y el baloncesto, pero finalmente decidió enfocarse en la actuación y se graduó de Bellas artes en la Tisch School of the Arts, perteneciente a la Universidad de Nueva York. ",null));
        tg.add(new Personaje(3L,"Jennifer Connelly",52,56.0,"es una actriz y modelo estadounidense. Comenzó su carrera como modelo infantil antes de debutar en la actuación en el filme de Sergio Leone Érase una vez en América (1984). Un año después, realizó su primer papel protagónico en la película de terror de Dario Argento Phenomena, y en 1986 obtuvo reconocimiento en su país al participar junto con David Bowie en la cinta de fantasía Labyrinth,",null));


        ArrayList<Personaje> av = new ArrayList<>();
        av.add(new Personaje(1L,"Sam Worthington",46,85.0,"Worthington nació en Godalming, Surrey, Inglaterra; pero durante su infancia se mudó a Perth, Australia.1\u200BAsistió al John Curtin College of The Arts, pero finalmente abandonó la escuela a los diecisiete años y se dedicó a la construcción y a algunos trabajos esporádicos, estableciéndose en Sídney.2\u200B Cuando tenía diecinueve años y trabajaba como albañil, hizo una prueba para el National Institute of Dramatic Art (NIDA), donde fue aceptado y se graduó en 1998.3\u200B",null));
        av.add(new Personaje(2L,"Zoe Saldaña",44,58.0,"es una actriz y modelo estadounidense. Tuvo algunos de sus primeros papeles en las películas Center Stage, del año 2000, y Crossroads, de 2002. Más tarde ganó relevancia por interpretar a Anamaría en Pirates of the Caribbean: The Curse of the Black Pearl de 2003",null));
        av.add(new Personaje(3L,"Sigourney Weaver",73,54.0,"es una actriz y productora estadounidense de cine, televisión y teatro. Ha sido candidata a los Premios Óscar y a los Premios del Sindicato de Actores.2\u200B Ha sido ganadora de dos Globo de Oro en las categorías de mejor actriz en drama y mejor actriz de reparto",null));

        ArrayList<Personaje> gcb = new ArrayList<>();
        gcb.add(new Personaje(1L,"Antonio Banderas",62,75.0,"es un actor, cantante, actor de voz, productor, director, perfumista y empresario español.Banderas comenzó su carrera como actor en el teatro en España y poco más tarde en el cine con una serie de películas del director Pedro Almodóvar en la década de 1980. Después, pasó a participar también en películas de Hollywood.",null));
        gcb.add(new Personaje(2L,"Salma Hayek",56,60.0,"es una actriz, empresaria y productora mexicana. Es una de las ocho actrices latinoamericanas nominadas como mejor actriz principal o de reparto al premio Óscar",null));
        gcb.add(new Personaje(3L,"Harvey Guillen",32,88.0,"es un actor estadounidense, reconocido por su papel como Guillermo de la Cruz en la serie de televisión de 2019 What We Do in the Shadows",null));

        peliculaList =  new ArrayList<>(Arrays.asList(
                new Pelicula(1L,"Batman", LocalDate.of(1995,01,05),1,batman),
                new Pelicula(2L,"El hombre del norte", LocalDate.of(2003,01,05),2,hdn),
                new Pelicula(3L,"Top Gun: Maverick", LocalDate.of(2005,01,05),3,tg),
                new Pelicula(4L,"Avatar: El camino del agua", LocalDate.of(2010,01,05),4,av),
                new Pelicula(5L,"Gato con botas: El último deseo", LocalDate.of(2020,01,05),5,gcb)
        ));
    }

    @Override
    public List<Pelicula> findAll(){return this.peliculaList;}

    @Override
    public Optional<Pelicula> findByTitle(String title){
        return this.peliculaList.stream().filter(p -> p.getTitulo().equalsIgnoreCase(title)).findFirst();
    }

    @Override
    public Pelicula save(Pelicula pelicula){
        this.peliculaList.add(pelicula);
        return pelicula;
    }

    @Override
    public Optional<Pelicula> findById(Long id){
        Optional<Pelicula> pelicula = this.peliculaList.stream().filter(p -> p.getId().equals(id)).findFirst();
        return pelicula;
    }
}
