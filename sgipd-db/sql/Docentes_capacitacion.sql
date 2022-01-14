CREATE TABLE SGIPD_DEV.dbo.Docentes_capacitacion (
	id_capacitacion bigint IDENTITY(0,1) NOT NULL,
	id_sigobsol_usuario bigint NOT NULL,
	nombre_capacitacion varchar(250) NOT NULL,
	cantidad_horas smallint NOT NULL,
	institucion varchar(250) NOT NULL,
	fecha_inicio timestamp NOT NULL,
	fecha_finalizacion timestamp NOT NULL,
	pais varchar(250) NOT NULL,
	diploma_obtenido varchar(300) NOT NULL,
	indice_capacitacion smallint NOT NULL,
	CONSTRAINT Docentes_capacitaciones_PK PRIMARY KEY (id_capacitacion)
);
EXEC SGIPD_DEV.sys.sp_addextendedproperty 'MS_Description', N'Tabla para guardar capacitaciones de los docentes en concurso', 'schema', N'dbo', 'table', N'Docentes_capacitacion';

