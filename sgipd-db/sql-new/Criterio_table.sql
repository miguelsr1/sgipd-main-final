--liquibase formatted sql

--changeset xtecuan:23 dbms:mssql
CREATE TABLE Criterio (
	id_criterio bigint IDENTITY(1,1) NOT NULL,
	nombre_criterio varchar(25) COLLATE Modern_Spanish_CI_AS NOT NULL,
	descripcion_criterio text COLLATE Modern_Spanish_CI_AS NOT NULL,
	puntaje_maximo float NOT NULL,
	descripcion_puntaje text COLLATE Modern_Spanish_CI_AS NOT NULL,
	formula varchar(350) COLLATE Modern_Spanish_CI_AS NULL,
	indice_criterio bigint NOT NULL,
	fraccion_ponderacion decimal(5,4) NULL,
	CONSTRAINT Criterio_PK PRIMARY KEY (id_criterio)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Criterios de seleccion Plazas docentes', 'schema', N'dbo', 'table', N'Criterio';
--rollback drop table Criterio;  