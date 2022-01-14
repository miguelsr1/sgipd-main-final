--liquibase formatted sql

--changeset xtecuan:27 dbms:mssql
CREATE TABLE Calificaciones (
	id_calificacion bigint IDENTITY(0,1) NOT NULL,
	id_tramite_aplic bigint NOT NULL,
	id_criterio bigint NOT NULL,
	valor_calif decimal(5,4) NULL,
	valor_ponderacion decimal(5,4) NULL,
	fecha_ingreso datetime DEFAULT getdate() NULL,
	usuario_ingreso varchar(100) COLLATE Modern_Spanish_CI_AS NULL,
	fecha_actualizacion datetime DEFAULT getdate() NULL,
	usuario_actualizacion varchar(100) COLLATE Modern_Spanish_CI_AS NULL,
	aprobacion bit DEFAULT 0 NULL,
	CONSTRAINT Calificaciones_PK PRIMARY KEY (id_calificacion),
	CONSTRAINT Calificaciones_FK_Criterio FOREIGN KEY (id_criterio) REFERENCES Criterio(id_criterio),
	CONSTRAINT Calificaciones_FK_Docentes_aplicaciones FOREIGN KEY (id_tramite_aplic) REFERENCES Docentes_aplicaciones(id_tramite_aplic)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Criterios de seleccion Plazas docentes', 'schema', N'dbo', 'table', N'Calificaciones';
--rollback drop table Calificaciones;  