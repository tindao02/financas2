CREATE TABLE usuario
(
	id bigint not null AUTO_INCREMENT UNIQUE,
   	nome varchar(60) NOT null,
    email varchar(255) not null UNIQUE,
    senha varchar(20) not null,
    
    PRIMARY KEY(id)
);