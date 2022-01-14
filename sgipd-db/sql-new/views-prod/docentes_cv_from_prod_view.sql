--liquibase formatted sql

--changeset xtecuan:0.3 dbms:mssql
CREATE VIEW dbo.docentes_cv_from_prod AS
SELECT
    --Generalidades
    dco.[Código de trámite] as [codigo_de_tramite],
	dco.[Código de solicitante] as [codigo_de_solicitante],
	dco.[Codigo de tipo de trámite] as [codigo_de_tipo_de_tramite],
	dco.Nombres as [nombres],
	dco.Apellidos as [apellidos],
	dco.[Dirección actual de residencia] as [direccion_actual_de_residencia],
	dco.Departamento as [departamento],
	dco.Municipio as [municipio],
	dco.NIP as [nip],
	dco.DUI as [dui],
	dco.Correo as [correo],
	dco.[Nivel docente] as [nivel_docente],
	dco.[Teléfono fijo] as [telefono_fijo],
	dco.[Teléfono celular] as [telefono_celular],
	dco.Discapacidad as [discapacidad],
	--Listado de estudios realizados relacionados a la plaza a la que aplic
	--1
	dco.[Grado académico 1] as [grado_academico_1],
	dco.[Especialidad 1] as [especialidad_1],
	dco.[Institución educativa 1] [institucion_educativa_1],
	dco.[Año de graduación 1] as [annio_de_graduacion_1],
	--2
	dco.[Grado académico 2] as [grado_academico_2],
	dco.[Especialidad 2] as [especialidad_2],
	dco.[Institución educativa 2] [institucion_educativa_2],
	dco.[Año de graduación 2] as [annio_de_graduacion_2],
	--3
	dco.[Grado académico 3] as [grado_academico_3],
	dco.[Especialidad 3] as [especialidad_3],
	dco.[Institución educativa 3] [institucion_educativa_3],
	dco.[Año de graduación 3] as [annio_de_graduacion_3],
	--4
	dco.[Grado académico 4] as [grado_academico_4],
	dco.[Especialidad 4] as [especialidad_4],
	dco.[Institución educativa 4] [institucion_educativa_4],
	dco.[Año de graduación 4] as [annio_de_graduacion_4],
	--Listado de capacitaciones
	--1
	dco.[Nombre capacitación 1] as [nombre_capacitacion_1],
	dco.[Cantidad horas 1] as [cantidad_horas_1],
	dco.[Institución 1] as [Institucion_1],
	dco.[Fecha inicio 1] as [fecha_inicio_1],
	dco.[Fecha finalización 1] as [fecha_finalizacion_1],
	dco.[País 1] as [Pais_1],
	dco.[Diploma obtenido 1] as [diploma_obtenido_1],
	--2
	dco.[Nombre capacitación 2] as [nombre_capacitacion_2],
	dco.[Cantidad horas 2] as [cantidad_horas_2],
	dco.[Institución 2] as [Institucion_2],
	dco.[Fecha inicio 2] as [fecha_inicio_2],
	dco.[Fecha finalización 2] as [fecha_finalizacion_2],
	dco.[País 2] as [Pais_2],
	dco.[Diploma obtenido 2] as [diploma_obtenido_2],
	--3
	dco.[Nombre capacitación 3] as [nombre_capacitacion_3],
	dco.[Cantidad horas 3] as [cantidad_horas_3],
	dco.[Institución 3] as [Institucion_3],
	dco.[Fecha inicio 3] as [fecha_inicio_3],
	dco.[Fecha finalización 3] as [fecha_finalizacion_3],
	dco.[País 3] as [Pais_3],
	dco.[Diploma obtenido 3] as [diploma_obtenido_3],
	--4
	dco.[Nombre capacitación 4] as [nombre_capacitacion_4],
	dco.[Cantidad horas 4] as [cantidad_horas_4],
	dco.[Institución 4] as [Institucion_4],
	dco.[Fecha inicio 4] as [fecha_inicio_4],
	dco.[Fecha finalización 4] as [fecha_finalizacion_4],
	dco.[País 4] as [Pais_4],
	dco.[Diploma obtenido 4] as [diploma_obtenido_4],
	--5
	dco.[Nombre capacitación 5] as [nombre_capacitacion_5],
	dco.[Cantidad horas 5] as [cantidad_horas_5],
	dco.[Institución 5] as [Institucion_5],
	dco.[Fecha inicio 5] as [fecha_inicio_5],
	dco.[Fecha finalización 5] as [fecha_finalizacion_5],
	dco.[País 5] as [Pais_5],
	dco.[Diploma obtenido 5] as [diploma_obtenido_5],
	--Listado de experiencia laboral
	--1
	dco.[Institución educativa nacional 1] as [institucion_educativa_nacional_1],
	dco.[Institución educativa extranjero 1] as [institucion_educativa_extranjero_1],
	dco.[Cantidad de años 1] as [cantidad_de_annios_1],
	dco.[Departamento 1] as [departamento_1],
	dco.[Municipio 1] as [municipio_1],
	dco.[Desde 1] as [desde_1],
	dco.[Hasta 1] as [hasta_1],
	dco.[Nombramiento 1] as [nombramiento_1],
	dco.[Sector 1] as [sector_1],
	--2
	dco.[Institución educativa nacional 2] as [institucion_educativa_nacional_2],
	dco.[Institución educativa extranjero 2] as [institucion_educativa_extranjero_2],
	dco.[Cantidad de años 2] as [cantidad_de_annios_2],
	dco.[Departamento 2] as [departamento_2],
	dco.[Municipio 2] as [municipio_2],
	dco.[Desde 2] as [desde_2],
	dco.[Hasta 2] as [hasta_2],
	dco.[Nombramiento 2] as [nombramiento_2],
	dco.[Sector 2] as [sector_2],
	--3
	dco.[Institución educativa nacional 3] as [institucion_educativa_nacional_3],
	dco.[Institución educativa extranjero 3] as [institucion_educativa_extranjero_3],
	dco.[Cantidad de años 3] as [cantidad_de_annios_3],
	dco.[Departamento 3] as [departamento_3],
	dco.[Municipio 3] as [municipio_3],
	dco.[Desde 3] as [desde_3],
	dco.[Hasta 3] as [hasta_3],
	dco.[Nombramiento 3] as [nombramiento_3],
	dco.[Sector 3] as [sector_3],
	--4
	dco.[Institución educativa nacional 4] as [institucion_educativa_nacional_4],
	dco.[Institución educativa extranjero 4] as [institucion_educativa_extranjero_4],
	dco.[Cantidad de años 4] as [cantidad_de_annios_4],
	dco.[Departamento 4] as [departamento_4],
	dco.[Municipio 4] as [municipio_4],
	dco.[Desde 4] as [desde_4],
	dco.[Hasta 4] as [hasta_4],
	dco.[Nombramiento 4] as [nombramiento_4],
	dco.[Sector 4] as [sector_4]
FROM
	SOL_MINED_SV_PROD.dbo.docentes_cv_05_oct_2021 dco;
--rollback drop view docentes_cv_from_prod;