--liquibase formatted sql

--changeset xtecuan:14 dbms:mssql
CREATE TABLE Instituciones_educativas (
	id bigint IDENTITY(1,1) NOT NULL,
	nombre varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
	tipo_institucion varchar(25) COLLATE Modern_Spanish_CI_AS NOT NULL,
	CONSTRAINT institucion_educativa_PK PRIMARY KEY (id)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Tabla de Instituciones Educativas', 'schema', N'dbo', 'table', N'Instituciones_educativas';
--rollback drop table Instituciones_educativas;  