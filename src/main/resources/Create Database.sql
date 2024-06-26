/*

Comandos basicos:

CREATE DATABASE ***

SELECT * FROM ***

INSERT INTO *** (***) VALUES ('***');

UPDATE *** SET *** = 'tarara' WHERE ID = *

DELETE FROM *** where id =*

ALTER TABLE *** RENAME COLUMN **** TO ****

*/


create database Locadora_filmes;
create schema Locadora_filmes;




CREATE TABLE Locadora_filmes.ENDERECO
(
    COD_END     serial PRIMARY KEY,
    LOGRADOURO  VARCHAR(40),
    TIPO_LOG    VARCHAR(40),
    COMPLEMENTO VARCHAR(20),
    CIDADE      VARCHAR(60),
    UF          varchar(2),
    CEP         varchar(8),
    NUMERO      varchar(5),
    BAIRRO      varchar(60)

);



CREATE TABLE Locadora_filmes.PROFISSAO
(
    COD_PROF SERIAL PRIMARY KEY,
    NAME     varchar(60)
);



CREATE TABLE Locadora_filmes.CLIENTE
(
    COD_CLI    SERIAL PRIMARY KEY,
    CPF        varchar(11),
    NOME       varchar(60),
    TELEFONE   varchar(10),

    FK_COD_CLI INTEGER,
    FOREIGN KEY (FK_COD_CLI) REFERENCES Locadora_filmes.PROFISSAO (COD_PROF)
);



CREATE TABLE Locadora_filmes.CLI_ENDERECO
(
    FK_COD_END int not null,
    FK_CLI     int not null,
    FOREIGN KEY (FK_COD_END) REFERENCES Locadora_filmes.ENDERECO (COD_END), /* LIGA COD_END do ENDEREÇO */
    FOREIGN KEY (FK_CLI) REFERENCES Locadora_filmes.CLIENTE (COD_CLI) /* LIGA COM CLIENTE COD_CLI, não confundir com FK_COD_CLI */
);



CREATE TABLE Locadora_filmes.DEPENDENTE
(
    FK_COD_CLI INTEGER NOT NULL,
    FK_COD_DEP INTEGER NOT NULL,
    PARENTESCO VARCHAR(20),
    PRIMARY KEY (FK_COD_CLI, FK_COD_DEP), /* CHAVE PRIMARIA COMPOSTA, DESDE QUE A COMBINACAO NAO SE REPITA*/
    FOREIGN KEY (FK_COD_CLI) REFERENCES Locadora_filmes.CLIENTE (COD_CLI),
    FOREIGN KEY (FK_COD_DEP) REFERENCES Locadora_filmes.CLIENTE (COD_CLI)
);


CREATE TABLE Locadora_filmes.LOCACAO
(
    COD_LOC    SERIAL PRIMARY KEY NOT NULL,
    DATA_LOC   DATE,
    DESCONTO   NUMERIC(15, 2),
    MULTA      NUMERIC(15, 2),
    SUB_TOTAL  NUMERIC(15, 2),

    FK_COD_LOC INT                 NOT NULL,
    FOREIGN KEY (FK_COD_LOC) REFERENCES Locadora_filmes.CLIENTE (COD_CLI)
);



CREATE TABLE Locadora_filmes.LOCACAO_FILME
(
    FK_COD_LOC   INTEGER  NOT NULL,
    FK_COD_FILME INTEGER  NOT NULL,

    VALOR        NUMERIC(15,2),
    NUM_DIAS     INTEGER,
    DATA_DEVOL   DATE,

    PRIMARY KEY (FK_COD_LOC, FK_COD_FILME),
    FOREIGN KEY (FK_COD_LOC) REFERENCES Locadora_filmes.LOCACAO (COD_LOC),
    FOREIGN KEY (FK_COD_FILME) REFERENCES Locadora_filmes.FILMES (COD_FILMES)
);


CREATE TABLE Locadora_filmes.CATEGORIA
(
    COD_CAT SERIAL PRIMARY KEY,
    NOME    VARCHAR(60),
    VALOR   NUMERIC(15,2)
);


CREATE TABLE Locadora_filmes.GENERO
(
    COD_GEN SERIAL PRIMARY KEY,
    NOME    VARCHAR(60)
);



CREATE TABLE Locadora_filmes.ATOR
(
    COD_ATOR SERIAL PRIMARY KEY,
    NOME     VARCHAR(60)
);


CREATE TABLE Locadora_filmes.FILMES
(
    COD_FILMES      SERIAL PRIMARY KEY,
    TITULO_ORIGINAL VARCHAR(100),
    TITULO          VARCHAR(100),
    QUANTIDADE      INTEGER,

    FK_COD_CAT      INTEGER,
    FK_COD_GEN      INTEGER,

    FOREIGN KEY (FK_COD_CAT) REFERENCES Locadora_filmes.CATEGORIA (COD_CAT),
    FOREIGN KEY (FK_COD_GEN) REFERENCES Locadora_filmes.GENERO (COD_GEN)

);

CREATE TABLE Locadora_filmes.FILME_ATOR
(
    FK_COD_ATOR  INTEGER NOT NULL,
    FK_COD_FILME INTEGER NOT NULL,


    PRIMARY KEY (FK_COD_ATOR, FK_COD_FILME),
    FOREIGN KEY (FK_COD_ATOR) REFERENCES Locadora_filmes.ATOR (COD_ATOR),
    FOREIGN KEY (FK_COD_FILME) REFERENCES Locadora_filmes.FILMES (COD_FILMES),

    ATOR         VARCHAR(20),
    DIRETOR      VARCHAR(20)
);

/*
SELECT * FROM LOCACAO
SELECT * FROM LOCACAO_FILME
SELECT * FROM FILMES
SELECT * FROM FILME_ATOR **
SELECT * FROM ATOR
SELECT * FROM GENERO
SELECT * FROM CATEGORIA
SELECT * FROM CLIENTE
SELECT * FROM PROFISSAO
SELECT * FROM CLI_ENDERECO
SELECT * FROM ENDERECO
SELECT * FROM DEPENDENTE



Exercício para fazer em aula:
Enviar script da criação do banco/tabelas abaixo  : FEITO
inserção de 15 filmes, 10 clientes
20 locações

*/



INSERT INTO CATEGORIA (NOME, VALOR) VALUES ('TERROR', 10); /* Exemplo para inserir valores no campo categoria*/
INSERT INTO CATEGORIA (NOME, VALOR) VALUES ('COMEDIA', 10); /* Exemplo para inserir valores no campo categoria*/
INSERT INTO CATEGORIA (NOME, VALOR) VALUES ('ROMANCE', 10); /* Exemplo para inserir valores no campo categoria*/