package com.bootcamp.besysoft.dominio;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private LocalDate estreno;

    private Integer calificacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genero_id")
    private Genero  genero;

    @ManyToMany(fetch =  FetchType.EAGER)
    @JoinTable(
            name = "peliculas_personajes",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id")
    )
    @JsonIgnoreProperties("peliculas")
    private List<Personaje> personajes;

    public Pelicula(Long id,String titulo,LocalDate estreno,Integer calificacion,List<Personaje> personajes){
        this.id = id;
        this.titulo = titulo;
        this.estreno = estreno;
        this.calificacion = calificacion;
        this.personajes = personajes;
    }
}
