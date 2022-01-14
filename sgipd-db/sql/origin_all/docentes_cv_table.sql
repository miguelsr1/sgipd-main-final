-- Drop table

-- DROP TABLE SGIPD_DEV.dbo.docentes_cv_from_prod;

CREATE TABLE SGIPD_DEV.dbo.docentes_cv_from_prod (
	codigo_de_tramite bigint NULL,
	codigo_de_solicitante bigint NULL,
	codigo_de_tipo_de_tramite bigint NULL,
	nombres varchar(100) COLLATE Modern_Spanish_CI_AS NULL,
	apellidos varchar(100) COLLATE Modern_Spanish_CI_AS NULL,
	direccion_actual_de_residencia varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	departamento varchar(100) COLLATE Modern_Spanish_CI_AS NULL,
	municipio varchar(100) COLLATE Modern_Spanish_CI_AS NULL,
	nip varchar(50) COLLATE Modern_Spanish_CI_AS NULL,
	dui varchar(50) COLLATE Modern_Spanish_CI_AS NULL,
	correo varchar(255) COLLATE Modern_Spanish_CI_AS NULL,
	nivel_docente varchar(50) COLLATE Modern_Spanish_CI_AS NULL,
	telefono_fijo varchar(150) COLLATE Modern_Spanish_CI_AS NULL,
	telefono_celular varchar(150) COLLATE Modern_Spanish_CI_AS NULL,
	discapacidad varchar(255) COLLATE Modern_Spanish_CI_AS NULL
);
