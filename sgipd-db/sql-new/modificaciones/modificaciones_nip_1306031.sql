SELECT
	rdppad.*
INTO
	ReporteDocentesPruebaPsicometricaAll_Data_29_10_2021
FROM
	ReporteDocentesPruebaPsicometricaAll_Data rdppad 

GO 

SELECT
	c.*
INTO
	Calificaciones_29_10_2021
FROM
	Calificaciones c 

GO

UPDATE
	ReporteDocentesPruebaPsicometricaAll_Data
SET
	resultadospruebaconocimientos = 6.00,
	aprobacion = 1
WHERE
	nip = '1306031';

GO
UPDATE
	Calificaciones
SET
	valor_calif = 6.00 ,
	valor_ponderacion = 0.25 * 6.00,
	aprobacion = 1,
	estatus = 'APROBADO',
	observacion = 'RE: Caso aciertos de formación general no incluidos. From: Gustavo Adolfo Solórzano Echeverría <Gustavo.Solorzano@mined.gob.sv> Sent: Friday, October 29, 2021 11:16 AM To: Julian Rivera Pineda <julian.rivera@mined.gob.sv>'
WHERE
	id_tramite_aplic IN (
	SELECT
		rdppad.idTramite
	FROM
		ReporteDocentesPruebaPsicometricaAll_Data rdppad
	WHERE
		rdppad.nip = '1306031'
);

GO
