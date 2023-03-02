drop table if exists generos CASCADE;
drop table if exists peliculas CASCADE;
drop table if exists peliculas_personajes CASCADE;
drop table if exists personajes CASCADE;


    create table generos (
       id bigint generated by default as identity,
        nombre varchar(255),
        primary key (id)
    );


    create table peliculas (
       id bigint generated by default as identity,
        calificacion integer,
        estreno date,
        titulo varchar(255),
        genero_id bigint,
        primary key (id)
    );


    create table peliculas_personajes (
       pelicula_id bigint not null,
        personaje_id bigint not null
    );


    create table personajes (
       id bigint generated by default as identity,
        edad integer,
        historia varchar(255),
        nombre varchar(255),
        peso double,
        primary key (id)
    );


    alter table peliculas
       add constraint FKfty0as0fblr2te2ict41vewm1
       foreign key (genero_id)
       references generos;


    alter table peliculas_personajes
       add constraint FK9vdndfnqq5vwhjajneb5ltpw9
       foreign key (personaje_id)
       references personajes;

    alter table peliculas_personajes
       add constraint FKlc3kt6rcqb17abjhoa8eghe66
       foreign key (pelicula_id)
       references peliculas;


