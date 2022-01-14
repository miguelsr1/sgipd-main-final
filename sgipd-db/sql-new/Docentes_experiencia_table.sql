--liquibase formatted sql

--changeset xtecuan_madafaquer:21 dbms:mssql
CREATE TABLE Docentes_experiencia (
	id_experiencia bigint IDENTITY(0,1) NOT NULL,
	id_sigobsol_usuario bigint NOT NULL,
	institucion_educativa_nacional varchar(250) NULL,
	institucion_educativa_extranjero varchar(250) NULL,
	cantidad_de_annios smallint NOT NULL,
	departamento varchar(100) NULL,
	municipio varchar(250) NULL,
	desde smalldatetime NULL,
	hasta smalldatetime NULL,
	nombramiento varchar(300) NULL,
	sector varchar(100) NULL,
	indice_experiencia smallint NOT NULL,
	CONSTRAINT Docentes_experiencia_PK PRIMARY KEY (id_experiencia)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Tabla para guardar la experiencia del aspirante', 'schema', N'dbo', 'table', N'Docentes_experiencia';
--rollback drop table Docentes_experiencia;  
