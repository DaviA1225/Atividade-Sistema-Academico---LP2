use academicodb;
select * from cursos;

drop table cursos;

create table Cursos(
codigo int NOT null AUTO_INCREMENT,
nome varchar(50) not null,
nivel int,
cargaHoraria int,
situacao boolean,
primary key(codigo)
);
