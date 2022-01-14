--liquibase formatted sql

--changeset xtecuan:25 dbms:mssql
CREATE TABLE Docentes_aplicaciones (
	id_tramite_aplic bigint NOT NULL,
	id_sigobsol_usuario bigint NOT NULL,
	tipo_tramite bigint NULL,
	id_secuencial_plaza bigint NULL,
	CONSTRAINT Docentes_aplicaciones_PK PRIMARY KEY (id_tramite_aplic),
	CONSTRAINT Docentes_aplicaciones_FK_Docentes FOREIGN KEY (id_sigobsol_usuario) REFERENCES Docentes(id_sigobsol_usuario),
	CONSTRAINT Docentes_aplicaciones_FK_Plazas FOREIGN KEY (id_secuencial_plaza) REFERENCES Plazas(id_secuencial),
	CONSTRAINT Docentes_aplicaciones_FK_Tipo_tramite FOREIGN KEY (tipo_tramite) REFERENCES Tipo_tramite(id_tipo_tramite)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Criterios de seleccion Plazas docentes', 'schema', N'dbo', 'table', N'Docentes_aplicaciones';
--rollback drop table Docentes_aplicaciones;  