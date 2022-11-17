package com.cieep;

import com.cieep.modelos.Abonado;
import com.cieep.modelos.Alquiler;
import com.cieep.modelos.Autor;
import com.cieep.modelos.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Abonado abonado = new Abonado();
        abonado.setNombre("Pepe");
        Autor autor = new Autor();
        autor.setNombre("Carlos");
        Libro libro = new Libro();
        libro.setTitulo("Me quiero morir");
        libro.setAutor(autor);
        Alquiler alquiler = new Alquiler();
        alquiler.setFecha(Date.valueOf(LocalDate.now()));
        abonado.getAlquileres().add(alquiler);
        libro.getAlquires().add(alquiler);
        autor.getLibros().add(libro);
        alquiler.setLibro(libro);
        alquiler.setAbonado(abonado);

        //CREA LA VARIABLE QUE PUEDE CONECTAR
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //LA VARIBLE DE LA CONEXIÓN
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(abonado);
        session.persist(autor);
        session.persist(libro);
        session.persist(alquiler);

        session.getTransaction().commit();
        session.close();
    }
}
