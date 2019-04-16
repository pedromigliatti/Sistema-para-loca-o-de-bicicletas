create table Cliente
(
id integer not null generated always as identity (start with 1, increment by 1),
email varchar(50) not null,
senha varchar(100) not null,
cpf varchar(11) not null unique,
nome varchar(50) not null,
telefone varchar(11) not null,
sexo varchar(1) not null,
nascimento date not null,
ativo smallint not null,
CONSTRAINT Cliente_PK PRIMARY KEY (id)
);

create table Locadora
(
id integer not null generated always as identity (start with 1, increment by 1),
email varchar(50) not null,
senha varchar(100) not null,
cnpj varchar(11) not null unique,
nome varchar(50) not null,
cidade varchar(50) not null,
ativo smallint not null,
CONSTRAINT Locadora_PK PRIMARY KEY (id)
);

create table Locacao
(
id integer not null generated always as identity (start with 1, increment by 1),
cpf_cliente varchar(11) not null,
cnpj_locadora varchar(11) not null,
data_hora timestamp not null,
CONSTRAINT Locacao_PK PRIMARY KEY (id),
CONSTRAINT Cleinte_FK FOREIGN KEY (cpf_cliente) REFERENCES Cliente (cpf),
CONSTRAINT Locadora_FK FOREIGN KEY (cnpj_locadora) REFERENCES Locadora (cnpj)
);

create table Papel (
id integer not null generated always as identity (start with 1, increment by 1),
email varchar(50) not null,
nome varchar(50) not null,
constraint Papel_PK PRIMARY KEY (id)
);