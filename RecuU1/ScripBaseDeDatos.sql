create database autos;

use autos;

create table auto(
modelo varchar(40) ,
marca varchar(40),
color varchar (30),
NoSerie varchar(9)
);

select * from auto;

insert into auto values("gtr","Nissan","negro",123456789);

drop table auto;