--liquibase formatted sql

--changeset xtecuan:19 dbms:mssql
CREATE TABLE Docentes_estudios (
	id_estudios bigint IDENTITY(1,1) NOT NULL,
	id_sigobsol_usuario bigint NOT NULL,
	annio_graduacion bigint NULL,
	indice_titulo int NULL,
	id_grado_academico bigint NULL,
	id_especialidad bigint NULL,
	id_institucion_educativa bigint NULL,
	CONSTRAINT Docentes_estudios_PK PRIMARY KEY (id_estudios),
	CONSTRAINT Docentes_estudios_FK_Docentes FOREIGN KEY (id_sigobsol_usuario) REFERENCES Docentes(id_sigobsol_usuario),
	CONSTRAINT Docentes_estudios_FK_Instituciones_educativas FOREIGN KEY (id_institucion_educativa) REFERENCES Instituciones_educativas(id),
	CONSTRAINT Docentes_estudios_FK_Especialidad FOREIGN KEY (id_especialidad) REFERENCES Especialidad(id),
	CONSTRAINT Docentes_estudios_FK_Grado_academico FOREIGN KEY (id_grado_academico) REFERENCES Grado_academico(id_grado_academico)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Tabla con la informacion de los titulos de los docentes', 'schema', N'dbo', 'table', N'Docentes_estudios';
--rollback drop table Docentes_estudios;  