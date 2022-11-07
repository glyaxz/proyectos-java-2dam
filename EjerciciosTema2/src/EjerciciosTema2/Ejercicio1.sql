create database Unidad2;
use Unidad2;
create table productos(
	id tinyint primary key,
	descripcion varchar(50) not null,
	stockactual tinyint,
	stockminimo tinyint,
	pvp decimal(6,2)
);

create table clientes(
	id tinyint primary key,
	nombre varchar(50) not null,
	direccion varchar(50),
	poblacion varchar(50),
	telefono varchar(20),
	nif varchar(10)
);

create table ventas(
	idVentas tinyInt, 
	fechaventas date, 
	idCliente tinyint,
	idProducto tinyint,
	cantidad tinyint,
	foreign key (idProducto) references productos(id),
	foreign key (idCliente)  references clientes(id),
	primary key (idVentas)
);