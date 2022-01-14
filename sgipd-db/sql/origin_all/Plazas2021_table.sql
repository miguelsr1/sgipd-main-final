-- Drop table

-- DROP TABLE SGIPD_DEV.dbo.Plazas2021_from_prod;

CREATE TABLE SGIPD_DEV.dbo.Plazas2021_from_prod (
	ID_SECUENCIAL bigint NULL,
	COD_INFRA bigint NULL,
	NOMBRE_CENTRO_EDUCATIVO varchar(83) COLLATE Modern_Spanish_CI_AS NULL,
	Departamento varchar(12) COLLATE Modern_Spanish_CI_AS NULL,
	Municipio varchar(25) COLLATE Modern_Spanish_CI_AS NULL,
	Nivel_Educativo varchar(10) COLLATE Modern_Spanish_CI_AS NULL,
	Turno varchar(10) COLLATE Modern_Spanish_CI_AS NULL,
	Especialidad varchar(92) COLLATE Modern_Spanish_CI_AS NULL
);
