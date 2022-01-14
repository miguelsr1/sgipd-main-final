--liquibase formatted sql

--changeset xtecuan:17 dbms:mssql
CREATE TABLE Institucion_educativa (
	id bigint IDENTITY(1,1) NOT NULL,
	nombre varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
	CONSTRAINT institucion_educativa_PK PRIMARY KEY (id)
);