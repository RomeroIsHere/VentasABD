create user 'productosadmim'@'localhost' identified by 'productosDefaultPassphrase';
drop database productos;
create database if not exist productos;
use productos;
create table productos(
    idproducto int primary key,
    nombre varchar(50),
    descripcion varchar(50),
    precio decimal(10,2)
);
