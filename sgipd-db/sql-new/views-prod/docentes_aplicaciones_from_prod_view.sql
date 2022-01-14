--liquibase formatted sql

--changeset xtecuan:0.1 dbms:mssql
CREATE VIEW dbo.docentes_aplicaciones_from_prod AS
SELECT
    da.[Código de trámite] as [codigo_de_tramite],
	da.[Código de solicitante] as [codigo_de_solicitante],
	da.[Codio de tipo de trámite] as [codigo_de_tipo_de_tramite],
	da.[Id de plaza] as [id_de_plaza],
	da.[Nombre del C.E] as [nombre_del_CE],
	da.Departamento as [departamento],
	da.Municipio as [municipio],
	da.[Nivel educativo] as [nivel_educativo],
	da.Turno as [turno],
	da.Especialidad as [especialidad]
FROM
	SOL_MINED_SV_PROD.dbo.docentes_aplicaciones_05_oct_2021 da;
--rollback drop view docentes_aplicaciones_from_prod;