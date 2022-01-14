
---Sin registros vacios
select
	er.*
FROM
	(
	select
		dc1.codigo_de_solicitante as [codigo_de_solicitante],
		dc1.grado_academico_1 as [grado_academico],
		dc1.especialidad_1 as [especialidad],
		dc1.institucion_educativa_1 as [institucion_educativa],
		dc1.annio_de_graduacion_1 as [annio_de_graduacion],
		1 as [indice_titulo]
	from
		docentes_cv dc1
	WHERE
		dc1.grado_academico_1 is not NULL
		AND 
		dc1.especialidad_1 is not NULL
		AND 
		dc1.institucion_educativa_1 is NOT NULL
		AND 
		dc1.annio_de_graduacion_1 is not NULL
union all
	select
		dc2.codigo_de_solicitante as [codigo_de_solicitante],
		dc2.grado_academico_2 as [grado_academico],
		dc2.especialidad_2 as [especialidad],
		dc2.institucion_educativa_2 as [institucion_educativa],
		dc2.annio_de_graduacion_2 as [annio_de_graduacion],
		2 as [indice_titulo]
	from
		docentes_cv dc2
	WHERE
		dc2.grado_academico_2 is not NULL
		AND 
		dc2.especialidad_2 is not NULL
		AND 
		dc2.institucion_educativa_2 is NOT NULL
		AND 
		dc2.annio_de_graduacion_2 is not NULL
union all
	select
		dc3.codigo_de_solicitante as [codigo_de_solicitante],
		dc3.grado_academico_3 as [grado_academico],
		dc3.especialidad_3 as [especialidad],
		dc3.institucion_educativa_3 as [institucion_educativa],
		dc3.annio_de_graduacion_3 as [annio_de_graduacion],
		3 as [indice_titulo]
	from
		docentes_cv dc3
	WHERE
		dc3.grado_academico_3 is not NULL
		AND 
		dc3.especialidad_3 is not NULL
		AND 
		dc3.institucion_educativa_3 is NOT NULL
		AND 
		dc3.annio_de_graduacion_3 is not NULL
union all
	select
		dc4.codigo_de_solicitante as [codigo_de_solicitante],
		dc4.grado_academico_4 as [grado_academico],
		dc4.especialidad_4 as [especialidad],
		dc4.institucion_educativa_4 as [institucion_educativa],
		dc4.annio_de_graduacion_4 as [annio_de_graduacion],
		4 as [indice_titulo]
	from
		docentes_cv dc4
	WHERE
		dc4.grado_academico_4 is not NULL
		AND 
		dc4.especialidad_4 is not NULL
		AND 
		dc4.institucion_educativa_4 is NOT NULL
		AND 
		dc4.annio_de_graduacion_4 is not NULL 
) as er