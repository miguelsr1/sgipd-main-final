--liquibase formatted sql

--changeset xtecuan:10 dbms:mssql
CREATE TABLE Docentes (
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
	discapacidad varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	id_municipio bigint NULL,
	CONSTRAINT Docentes_PK PRIMARY KEY (id_sigobsol_usuario),
	CONSTRAINT Docentes_FK_Municipios FOREIGN KEY (id_municipio) REFERENCES Municipios(id),
	CONSTRAINT Docentes_FK_Tipo_tramite FOREIGN KEY (tipo_tramite) REFERENCES Tipo_tramite(id_tipo_tramite)
);
EXEC sp_addextendedproperty 'MS_Description', N'Tabla de Docentes en concurso', 'schema', N'dbo', 'table', N'Docentes';
--rollback drop table Docentes; 