-- Drop table

-- DROP TABLE SGIDTPVD.dbo.recepción_datos_sistemaGestionInterno;

CREATE TABLE SGIDTPVD.dbo.recepción_datos_sistemaGestionInterno (
                                                                    correlativo int IDENTITY(1,1) NOT NULL,
                                                                    nip int NOT NULL,
                                                                    dui_pasaporte varchar(20) COLLATE Modern_Spanish_CI_AS NOT NULL,
                                                                    apellidos varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
                                                                    nombres varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
                                                                    especialidad varchar(255) COLLATE Modern_Spanish_CI_AS NOT NULL,
                                                                    correo_electronico varchar(100) COLLATE Modern_Spanish_CI_AS NOT NULL,
                                                                    whatsapp int NOT NULL,
                                                                    CONSTRAINT PK__recepció__61D30E0F5429BB6F PRIMARY KEY (correlativo)
);
