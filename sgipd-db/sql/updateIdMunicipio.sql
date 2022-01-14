--liquibase formatted sql

--changeset xtecuan:8 dbms:mssql
INSERT INTO Departamentos (nombre)
	VALUES (N'Departamento No Definido');
INSERT INTO Municipios (id_departamento,nombre)
	VALUES (15,N'Municipio No Definido');
update CentrosEducativos set id_municipio = dbo.obtenerIdMunicipio(municipio,departamento);