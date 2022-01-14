--liquibase formatted sql

--changeset xtecuan:1 dbms:mssql
CREATE TABLE Departamentos (
	id bigint IDENTITY(1,1) NOT NULL,
	nombre varchar(25) COLLATE Modern_Spanish_CI_AS NOT NULL,
	CONSTRAINT Departamentos_PK PRIMARY KEY (id)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Tabla de Departamentos', 'schema', N'dbo', 'table', N'Departamentos';
--rollback drop table Departamentos;  