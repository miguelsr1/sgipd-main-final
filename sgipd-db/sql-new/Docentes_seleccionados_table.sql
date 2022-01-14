--liquibase formatted sql

--changeset xtecuan:28 dbms:mssql
CREATE TABLE Docentes_seleccionados (
	id_seleccionado bigint IDENTITY(0,1) NOT NULL,
	id_tramite_aplic bigint NOT NULL,
	valor_calif_total decimal(5,2) NOT NULL,
	posicion bigint NOT NULL,
	fecha_ingreso datetime DEFAULT getdate() NULL,
	usuario_ingreso varchar(100) NULL,
	fecha_actualizacion datetime DEFAULT getdate() NULL,
	usuario_actualizacion varchar(100) NULL,
	Observaciones text NULL,
	CONSTRAINT Seleccionados_PK PRIMARY KEY (id_seleccionado),
	CONSTRAINT Seleccionados_FK_Docentes_aplicaciones FOREIGN KEY (id_tramite_aplic) REFERENCES Docentes_aplicaciones(id_tramite_aplic)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Tabla de Seleccionados a Plazas docentes segun calculo', 'schema', N'dbo', 'table', N'Docentes_seleccionados';
--rollback drop table Docentes_seleccionados;  