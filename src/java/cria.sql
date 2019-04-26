CREATE TABLE Estado (
id INT NOT NULL GENERATED ALWAYS AS IDENTITY, 
nome varchar(30) NOT NULL, 
sigla varchar(2) NOT NULL, 
primary key (id));

CREATE TABLE Cidade (
id int NOT NULL GENERATED ALWAYS AS IDENTITY, 
nome varchar(80), 
estado_id int CONSTRAINT FK_CIDADE REFERENCES ESTADO, 
primary key (id));