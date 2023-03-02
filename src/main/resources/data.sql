INSERT INTO generos(nombre) values ('Terror');
INSERT INTO generos(nombre) values ('Aventura');
INSERT INTO generos(nombre) values ('Drama');
INSERT INTO generos(nombre) values ('Comedia');
INSERT INTO generos(nombre) values ('Ciencia Ficcion');




INSERT INTO peliculas(calificacion,estreno,titulo,genero_id) values (1,'2010-01-10','La luz del diablo',1);
INSERT INTO peliculas(calificacion,estreno,titulo,genero_id) values (2,'2020-02-20','La Monja',1);
INSERT INTO peliculas(calificacion,estreno,titulo,genero_id) values (3,'2005-03-30','La Huérfana: el origen',1);

INSERT INTO peliculas(calificacion,estreno,titulo,genero_id) values (4,'2015-04-05','Black Adam',2);
INSERT INTO peliculas(calificacion,estreno,titulo,genero_id) values (5,'2013-05-22','La ciudad perdida',2);
INSERT INTO peliculas(calificacion,estreno,titulo,genero_id) values (1,'2012-06-13','El hombre del norte',2);


INSERT INTO peliculas(calificacion,estreno,titulo,genero_id) values (2,'2021-07-12','Cielo de medianoche',3);
INSERT INTO peliculas(calificacion,estreno,titulo,genero_id) values (3,'2009-08-21','Guason',3);
INSERT INTO peliculas(calificacion,estreno,titulo,genero_id) values (4,'2011-09-18','A la deriva',3);



INSERT INTO personajes(edad,historia,nombre,peso) values (50,'Historia','Dwayne Johnson',85);
INSERT INTO personajes(edad,historia,nombre,peso) values (59,'Historia','Johnny Depp',70);
INSERT INTO personajes(edad,historia,nombre,peso) values (58,'Historia','Keanu Reeves',72);
INSERT INTO personajes(edad,historia,nombre,peso) values (56,'Historia','Adam Sandler',82);
INSERT INTO personajes(edad,historia,nombre,peso) values (54,'Historia','Will Smith',75);
INSERT INTO personajes(edad,historia,nombre,peso) values (53,'Historia','Personaje 1',84);
INSERT INTO personajes(edad,historia,nombre,peso) values (52,'Historia','Personaje 2',83);
INSERT INTO personajes(edad,historia,nombre,peso) values (51,'Historia','Personaje 3',82);
INSERT INTO personajes(edad,historia,nombre,peso) values (50,'Historia','Personaje 4',81);
INSERT INTO personajes(edad,historia,nombre,peso) values (59,'Historia','Personaje 5',80);
INSERT INTO personajes(edad,historia,nombre,peso) values (58,'Historia','Personaje 6',79);
INSERT INTO personajes(edad,historia,nombre,peso) values (49,'Historia','Personaje 7',78);
INSERT INTO personajes(edad,historia,nombre,peso) values (48,'Historia','Personaje 8',77);
INSERT INTO personajes(edad,historia,nombre,peso) values (47,'Historia','Personaje 9',76);
INSERT INTO personajes(edad,historia,nombre,peso) values (46,'Historia','Personaje 10',75);
INSERT INTO personajes(edad,historia,nombre,peso) values (45,'Historia','Personaje 11',74);
INSERT INTO personajes(edad,historia,nombre,peso) values (44,'Historia','Personaje 12',73);




INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (1,1);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (2,1);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (3,1);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (4,1);

INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (5,2);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (6,2);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (7,2);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (8,2);

INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (9,3);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (10,3);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (11,3);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (12,3);

INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (13,4);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (14,4);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (15,4);

INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (16,5);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (17,5);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (1,5);

INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (2,6);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (3,6);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (4,6);

INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (5,7);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (6,7);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (7,7);

INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (8,8);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (9,8);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (10,8);

INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (11,9);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (12,9);
INSERT INTO peliculas_personajes(personaje_id,pelicula_id) values (13,9);

