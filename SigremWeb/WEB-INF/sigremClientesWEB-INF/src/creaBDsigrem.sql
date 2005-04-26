create database sigremBD;

use sigremBD;

create table clientes
(
  codigo varchar(30) not null primary key,
  dni varchar(30) not null unique,
  nombre varchar(30),
  direccion varchar(30),
  cp varchar(30),
  poblacion varchar(30),
  provincia varchar(30),
  telefono1 varchar(30),
  telefono2 varchar(30),
  movil varchar(30),
  email varchar(30),
  fax varchar(30)
);

create table contratos
(
  codigoContrato varchar(30) not null primary key,
  matricula varchar(30) not null unique,
  fechaAlta varchar(30),
  fechaBaja varchar(30),
  codigoCliente varchar(30)
);

create table multas
(
  codigoMulta varchar(30) not null primary key,
  expediente varchar(30) not null unique,
  boletin varchar(30) not null unique,
  fechaDenuncia varchar(30),
  infraccion varchar(30),
  descripcion varchar(30),
  codigoContrato varchar(30)
);

create table recursos
(
  codigoRecurso varchar(30) not null primary key,
  fechaEmision varchar(30),
  escritoRecibido varchar(30),
  escritoPresentado varchar(30),
  estado varchar(30),
  descripcion varchar(30),
  codigoMulta varchar(30)
);

create table empleados
(
  codigo varchar(30) not null primary key,
  perfil varchar(30) not null,
  dni varchar(30) not null unique,
  nombre varchar(30),
  direccion varchar(30),
  cp varchar(30),
  poblacion varchar(30),
  provincia varchar(30),
  telefono1 varchar(30),
  telefono2 varchar(30),
  movil varchar(30),
  email varchar(30),
  fax varchar(30),
  nomina varchar(30)
);

create table asignadoRecursoEmpleado
(
  codigoRecurso varchar(30) not null primary key,
  codigoEmpleado varchar(30) not null
);


