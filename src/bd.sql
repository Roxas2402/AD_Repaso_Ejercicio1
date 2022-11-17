create database biblioteca;
use biblioteca;

create table abonados(
     id int auto_increment primary key ,
     nombre varchar(250) not null
);

create table autores (
     id int auto_increment primary key ,
     nombre varchar(250) not null
);

create table libros (
    id int auto_increment primary key ,
    titulo varchar(250) not null,
    id_autor int,
    foreign key (id_autor) references autores(id)
);

create table alquileres (
    id int auto_increment primary key ,
    fecha DATE not null ,
    id_abonado int,
    id_libro int,
    foreign key (id_libro) references libros(id),
    foreign key (id_abonado) references abonados(id)
);