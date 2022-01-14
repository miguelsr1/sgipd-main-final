-- Drop table

-- DROP TABLE SGIPD_DEV.dbo.docentes_aplicaciones_from_prod;

CREATE TABLE SGIPD_DEV.dbo.docentes_aplicaciones_from_prod (
	codigo_de_tramite bigint NULL,
	codigo_de_solicitante bigint NULL,
	codigo_de_tipo_de_tramite bigint NULL,
	id_de_plaza bigint NULL,
	nombre_del_CE varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	departamento varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	municipio varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	nivel_educativo varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	turno varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	especialidad varchar(255) COLLATE Modern_Spanish_CI_AS NULL
);
