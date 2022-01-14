--liquibase formatted sql

--changeset xtecuan:27 dbms:mssql
CREATE TABLE Calificaciones_extra_data (
                                                         id_cal_extra bigint IDENTITY(0,1) NOT NULL,
                                                         id_calificacion bigint NOT NULL,
                                                         universidad text COLLATE Modern_Spanish_CI_AS NULL,
                                                         titulo text COLLATE Modern_Spanish_CI_AS NULL,
                                                         annio_graduacion bigint NULL,
                                                         tipo_prueba varchar(25) COLLATE Modern_Spanish_CI_AS NULL,
                                                         aprobacion bit DEFAULT 0 NULL,
                                                         comentario text COLLATE Modern_Spanish_CI_AS NULL,
                                                         CONSTRAINT Calificaciones_extra_data_PK PRIMARY KEY (id_cal_extra),
                                                         CONSTRAINT Calificaciones_extra_data_FK_Calificaciones FOREIGN KEY (id_calificacion) REFERENCES Calificaciones(id_calificacion)
);
EXEC sys.sp_addextendedproperty 'MS_Description', N'Data extra ingresada en la carga de las notas', 'schema', N'dbo', 'table', N'Calificaciones_extra_data';
--rollback drop table Calificaciones_extra_data;