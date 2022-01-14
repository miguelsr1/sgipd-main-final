--liquibase formatted sql

--changeset xtecuan:19 dbms:mssql
CREATE TABLE Docentes_capacitacion (
	id_capacitacion bigint IDENTITY(0,1) NOT NULL,
	id_sigobsol_usuario bigint NOT NULL,
	nombre_capacitacion varchar(350) NOT NULL,
	cantidad_horas bigint NOT NULL,
	institucion varchar(350) NOT NULL,
	fecha_inicio smalldatetime NOT NULL,
	fecha_finalizacion smalldatetime NOT NULL,
	pais varchar(350) NOT NULL,
	diploma_obtenido varchar(350) NOT NULL,
	indice_capacitacion smallint NOT NULL,
	CONSTRAINT Docentes_capacitaciones_PK PRIMARY KEY (id_capacitacion)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Tabla para guardar capacitaciones de los docentes en concurso', 'schema', N'dbo', 'table', N'Docentes_capacitacion';
--rollback drop table Docentes_capacitacion;  
