package com.cieep.modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "abonados")
public class Abonado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;

    @OneToMany(mappedBy = "abonado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alquiler> alquileres;

    public Abonado() {
        alquileres = new ArrayList<>();
    }

    public Abonado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        alquileres = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(ArrayList<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }
}
