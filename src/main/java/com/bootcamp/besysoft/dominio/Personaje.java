package com.bootcamp.besysoft.dominio;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personajes")
public class Personaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer edad;

    private Double peso;

    private String historia;

    @ManyToMany(mappedBy = "personajes",fetch = FetchType.EAGER)
    private List<Pelicula> peliculas;
}
