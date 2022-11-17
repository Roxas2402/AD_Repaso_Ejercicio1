package com.cieep.modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//TODO: Las clases han de tener siempre un constructor vacío en el cual hay que inicializar el array en el caso de que sea necesario
//TODO: Las clases han de ser siempre Serializables

//Primero creamos los privates id y titulo
//Generamos constructores y constructor vacío
//Getters and setters
//Después creamos el List de Alquileres y lo ponemos en los dos constructores
//Cuando creemos una clase, hemos de crear el constructor de List correspondiente en las demás clases (min 2:11:21)
//Creamos un Autor autor porque el libro tiene un autor (si tuviera más autores tendría un arrayList)
//El abonado tiene muchos alquileres, por lo que el abonado es el que tiene que tener el arraylist
//Creamos los Getters y Setters
//A la hora de mapear, si el atributo es un objeto, la relación es 1 to 1 o many to 1. Cuando el objeto es un arrayList, la relación es 1 to many
//Aquí al tener el array de alquileres, la relación es 1 to many

//Aquí decimos a qué tabla de la base de datos corresponde esta clase
@Entity
@Table(name = "libros")
public class Libro implements Serializable {

    //Aquí le decimos qué parte de la clase es la que dice la ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Aquí le decimos que la columna título corresponde a esta parte de la clase
    @Column
    private String titulo;

    //Aquí decimos el tipo de relación
    //Creamos el Autor que es relacionado con id_autor
    //Muchos libros pueden ser escritos por un autor
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    //Un libro puede ser alquilado muchas veces
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alquiler> alquires;

    public Libro() {
        alquires = new ArrayList<>();
    }

    public Libro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        alquires = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Alquiler> getAlquires() {
        return alquires;
    }

    //Inicializamos el array list de alquileres
    public void setAlquires(ArrayList<Alquiler> alquires) {
        this.alquires = alquires;
    }
}

