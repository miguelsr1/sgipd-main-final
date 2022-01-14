--liquibase formatted sql

--changeset xtecuan:9 dbms:mssql
CREATE TABLE Docentes_concurso (
	id_sigobsol_usuario bigint NOT NULL,
	id_tramite bigint NOT NULL,
	tipo_tramite bigint NOT NULL,
	nombres varchar(250) COLLATE Modern_Spanish_CI_AS NULL,
	apellidos varchar(250) COLLATE Modern_Spanish_CI_AS NULL,
	direccion_postal varchar(250) COLLATE Modern_Spanish_CI_AS NULL,
	departamento varchar(25) COLLATE Modern_Spanish_CI_AS NULL,
	municipio varchar(25) COLLATE Modern_Spanish_CI_AS NULL,
	nip varchar(25) COLLATE Modern_Spanish_CI_AS NOT NULL,
	dui varchar(25) COLLATE Modern_Spanish_CI_AS NOT NULL,
	correo_e varchar(100) COLLATE Modern_Spanish_CI_AS NOT NULL,
	nivel_docente varchar(25) COLLATE Modern_Spanish_CI_AS NULL,
	tel_fijo varchar(35) COLLATE Modern_Spanish_CI_AS NULL,
	tel_celular varchar(35) COLLATE Modern_Spanish_CI_AS NULL,
	discapacidad varchar(20) COLLATE Modern_Spanish_CI_AS NULL,
	CONSTRAINT Docentes_concurso_csv_PK PRIMARY KEY (id_sigobsol_usuario)
);