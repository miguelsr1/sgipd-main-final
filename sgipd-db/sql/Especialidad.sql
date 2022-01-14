--liquibase formatted sql

--changeset xtecuan:15 dbms:mssql
CREATE TABLE Especialidad (
	id bigint IDENTITY(1,1) NOT NULL,
	nombre varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
	CONSTRAINT especialidad_PK PRIMARY KEY (id)
);