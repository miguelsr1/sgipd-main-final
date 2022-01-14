-- Drop table

-- DROP TABLE SGIDTPVD.dbo.envio_datos_SIGOBSOL;

CREATE TABLE SGIDTPVD.dbo.envio_datos_SIGOBSOL (
                                                   correlativo int IDENTITY(1,1) NOT NULL,
                                                   nip int NOT NULL,
                                                   dui_pasaporte varchar(20) COLLATE Modern_Spanish_CI_AS NOT NULL,
                                                   apellidos varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
                                                   nombres varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
                                                   especialidad varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
                                                   nota_formacion_general decimal(3,2) NULL,
                                                   nota_especialidad decimal(3,2) NULL,
                                                   nota_final decimal(3,2) NULL,
                                                   estatus varchar(15) COLLATE Modern_Spanish_CI_AS NULL,
                                                   CONSTRAINT PK__envio_da__61D30E0FBC89E75F PRIMARY KEY (correlativo)
);
