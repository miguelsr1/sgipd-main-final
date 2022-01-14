--liquibase formatted sql

--changeset xtecuan:5 dbms:mssql
CREATE TABLE Municipios (
	id bigint IDENTITY(1,1) NOT NULL,
	id_departamento bigint NOT NULL,
	nombre varchar(100) COLLATE Modern_Spanish_CI_AS NOT NULL,
	CONSTRAINT Municipios_PK PRIMARY KEY (id),
	CONSTRAINT Municipios_FK FOREIGN KEY (id_departamento) REFERENCES Departamentos(id)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Tabla de Municipios', 'schema', N'dbo', 'table', N'Municipios';
--rollback drop table Municipios;  