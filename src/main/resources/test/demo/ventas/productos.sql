create user 'productosadmim'@'localhost' identified by 'productosDefaultPassphrase';
drop database Tienda;
create database if not exists Tienda;
use Tienda;
grant all privileges on Tienda.* to 'productosadmim'@'localhost';
create table productos(
    idproducto int primary key auto_increment,
    nombre varchar(50),
    descripcion varchar(50),
    precio decimal(10,2)
);
