--liquibase formatted sql

--changeset xtecuan:17 dbms:mssql
CREATE TABLE Docentes_estudios (
	id_estudios bigint IDENTITY(1,1) NOT NULL,
	id_sigobsol_usuario bigint NOT NULL,
	grado_academico varchar(255) NULL,
	especialidad varchar(255) NULL,
	institucion_educativa varchar(255) NULL,
	annio_graduacion varchar(255) NULL,
	indice_titulo int NULL,
	id_grado_academico bigint NULL,
	id_especialidad bigint NULL,
	id_institucion_educativa bigint NULL,
	CONSTRAINT Docentes_estudios_PK PRIMARY KEY (id_estudios)
);
EXEC SGIPD_DEV.sys.sp_addextendedproperty 'MS_Description', N'Tabla con la informacion de los titulos de los docentes', 'schema', N'dbo', 'table', N'Docentes_estudios';
