-- Drop table

-- DROP TABLE SGIPD_DEV.dbo.docentes_estudios_from_prod;

CREATE TABLE SGIPD_DEV.dbo.docentes_estudios_from_prod (
	codigo_de_solicitante bigint NULL,
	grado_academico varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	especialidad varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	institucion_educativa varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	annio_de_graduacion varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	indice_titulo bigint NULL
);
