package com.bootcamp.besysoft.utilidades;

import com.bootcamp.besysoft.dominio.Genero;
import com.bootcamp.besysoft.dominio.Pelicula;
import com.bootcamp.besysoft.dominio.Personaje;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class Dummy {

    private List<Personaje> personajes;

    private List<Pelicula> peliculas;

    private List<Genero> generos;

    public Dummy() {


        this.personajes = new ArrayList<>();

        this.peliculas = new ArrayList<>();

        this.generos = new ArrayList<>();

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

        Pelicula p1  = new Pelicula(1L,"Batman", LocalDate.of(1995,01,05),1,batman);
        Pelicula p2  = new Pelicula(2L,"El hombre del norte", LocalDate.of(2003,01,05),2,hdn);
        Pelicula p3  = new Pelicula(3L,"Top Gun: Maverick", LocalDate.of(2005,01,05),3,tg);
        Pelicula p4  = new Pelicula(4L,"Avatar: El camino del agua", LocalDate.of(2010,01,05),4,av);
        Pelicula p5  = new Pelicula(5L,"Gato con botas: El último deseo", LocalDate.of(2020,01,05),5,gcb);



        ArrayList<Pelicula> ws = new ArrayList<>();
        ws.add(new Pelicula(1L,"Hancock", LocalDate.of(2008,04,05),4,null));
        ws.add(new Pelicula(2L,"Focus", LocalDate.of(2015,03,12),5,null));
        ws.add(new Pelicula(3L,"Proyecto géminis", LocalDate.of(2019,06,23),4,null));

        ArrayList<Pelicula> as = new ArrayList<>();
        as.add(new Pelicula(1L,"Pixels", LocalDate.of(2015,02,18),4,null));
        as.add(new Pelicula(2L,"Hotel Transylvania 3: Summer Vacation", LocalDate.of(2018,06,29),4,null));
        as.add(new Pelicula(3L,"El Halloween de Hubie", LocalDate.of(2020,07,12),4,null));

        ArrayList<Pelicula> jd = new ArrayList<>();
        jd.add(new Pelicula(1L,"Pirates of the Caribbean: The Curse of the Black Pearl", LocalDate.of(2003,03,12),4,null));
        jd.add(new Pelicula(2L,"Charlie y la fábrica de chocolate", LocalDate.of(2005,07,23),4,null));
        jd.add(new Pelicula(3L,"Animales fantásticos: los crímenes de Grindelwald", LocalDate.of(2018,06,14),4,null));

        ArrayList<Pelicula> dj = new ArrayList<>();
        dj.add(new Pelicula(1L,"Baywatch", LocalDate.of(2017,03,12),4,null));
        dj.add(new Pelicula(2L,"Rascacielos: Rescate en las alturas", LocalDate.of(2018,06,19),4,null));
        dj.add(new Pelicula(3L,"Black Adam", LocalDate.of(2022,02,22),4,null));

        ArrayList<Pelicula> kr = new ArrayList<>();
        kr.add(new Pelicula(1L,"Matrix", LocalDate.of(1999,03,12),4,null));
        kr.add(new Pelicula(2L,"John Wick", LocalDate.of(2014,04,20),4,null));
        kr.add(new Pelicula(3L,"Quizás para siempre", LocalDate.of(2019,05,29),4,null));


        Personaje per1  = new Personaje(1L,"Will Smith",54,75.0,"actor, rapero, productor cinematográfico, productor discográfico, guionista, empresario y filántropo estadounidense. Ha tenido éxito en sus dos facetas artísticas:5\u200B siendo ganador de un Premio Óscar con dos nominaciones previas, nominado a cuatro Premios Globo de Oro y ha ganado cuatro Premios Grammy.",ws);
        Personaje per2  = new Personaje(2L,"Adam Sandler",56,82.0,"comediante, actor, escritor, y productor estadounidense. Después de convertirse en miembro del elenco de Saturday Night Live, ha protagonizado una gran cantidad de películas de Hollywood que han recaudado cerca de dos mil millones de dólares de taquilla.",as);
        Personaje per3  = new Personaje(3L,"Johnny Depp",59,70.0,"actor, productor de cine y músico estadounidense. Ha sido nominado en tres ocasiones al Óscar y recibió un Globo de Oro,1\u200B un premio del Sindicato de Actores y un César",jd);
        Personaje per4  = new Personaje(4L,"Dwayne Johnson",50,85.0," actor y luchador profesional estadounidense.1\u200B Se desempeñó como luchador profesional para la WWE hasta su retirada oficial en 2019,2\u200B con el objetivo de centrarse en su carrera artística. Ha participado en una gran diversidad de películas siendo premiado en bastantes de ellas",dj);
        Personaje per5  = new Personaje(5L,"Keanu Reeves",58,72.0,"actor y músico canadiense.3\u200BEs conocido por Interpretar a Neo en \"Matrix\" y a John Wick En la trilogía \"John Wick\". Tiene sangre china por parte de su abuela.",kr);


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

        Genero g1 = new Genero(1L,"Aventura",peli1);
        Genero g2 = new Genero(2L,"Terror",peli2);
        Genero g3 = new Genero(3L,"Drama",peli3);
        Genero g4 = new Genero(4L,"Comedia",peli4);
        Genero g5 = new Genero(5L,"Ciencia Ficcion",peli5);

        personajes.add(per1);
        personajes.add(per2);
        personajes.add(per3);
        personajes.add(per4);
        personajes.add(per5);

        peliculas.add(p1);
        peliculas.add(p2);
        peliculas.add(p3);
        peliculas.add(p4);
        peliculas.add(p5);

        generos.add(g1);
        generos.add(g2);
        generos.add(g3);
        generos.add(g4);
        generos.add(g5);


    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
}
