--liquibase formatted sql

--changeset xtecuan:12 dbms:mssql
CREATE TABLE Plazas (
	id_secuencial bigint NOT NULL,
	codinfra bigint NOT NULL,
	nivel_educativo varchar(10) COLLATE Modern_Spanish_CI_AS NULL,
	turno varchar(10) COLLATE Modern_Spanish_CI_AS NULL,
	especialidad varchar(92) COLLATE Modern_Spanish_CI_AS NULL,
    CONSTRAINT Plazas_PK PRIMARY KEY (id_secuencial),
    CONSTRAINT Plazas_FK_Centros_educativos FOREIGN KEY (codinfra) REFERENCES Centros_educativos(codinfra)

);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Tabla de Plazas Normalizada', 'schema', N'dbo', 'table', N'Plazas';
--rollback drop table Plazas;  