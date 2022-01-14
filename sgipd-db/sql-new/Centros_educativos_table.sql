--liquibase formatted sql

--changeset xtecuan:7 dbms:mssql
CREATE TABLE Centros_educativos (
	codinfra bigint NOT NULL,
	nombrece varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
	departamento varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
	municipio varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
	id_municipio bigint NULL,
	CONSTRAINT CentrosEducativos_PK PRIMARY KEY (codinfra),
	CONSTRAINT CentrosEducativos_FK FOREIGN KEY (id_municipio) REFERENCES Municipios(id)
);
EXEC sp_addextendedproperty 'MS_Description', N'Tabla de Centros Educativos', 'schema', N'dbo', 'table', N'Centros_educativos';
--rollback drop table Centros_educativos;  