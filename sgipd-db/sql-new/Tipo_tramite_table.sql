--liquibase formatted sql

--changeset xtecuan:9.1 dbms:mssql
CREATE TABLE Tipo_tramite (
	id_tipo_tramite bigint NOT NULL,
	nombre_tramite varchar(255) NOT NULL,
	CONSTRAINT TipoTramite_PK PRIMARY KEY (id_tipo_tramite)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Criterios de seleccion Plazas docentes', 'schema', N'dbo', 'table', N'Tipo_tramite';
--rollback drop table Tipo_tramite;  