--liquibase formatted sql

--changeset xtecuan:13 dbms:mssql
CREATE TABLE Grado_academico (
	id_grado_academico bigint IDENTITY(1,1) NOT NULL,
	nombre varchar(50) NOT NULL,
	CONSTRAINT grado_academico_PK PRIMARY KEY (id_grado_academico)
);
EXEC SGIPD_DEV.sys.sp_addextendedproperty 'MS_Description', N'Catalogo de grado academico', 'schema', N'dbo', 'table', N'Grado_academico';
