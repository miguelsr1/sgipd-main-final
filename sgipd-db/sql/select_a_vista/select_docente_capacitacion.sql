
--Script para generar capacitación
select
	er.*
FROM
	(
	select
		d1.codigo_de_solicitante as [codigo_de_solicitante],
		d1.nombre_capacitacion_1 as [nombre_capacitacion],
		d1.cantidad_horas_1 as [cantidad_horas],
		d1.Institucion_1 as [institucion],
		d1.fecha_inicio_1 as [fecha_inicio],
		d1.fecha_finalizacion_1 as [fecha_finalizacion],
		d1.Pais_1 as [pais],
		d1.diploma_obtenido_1 as [diploma_obtenido],
		1 as [indice_capacitacion]
	from
		docentes_cv_all_rows d1
	WHERE
		d1.nombre_capacitacion_1 is not NULL
		AND

                      d1.Institucion_1 is NOT NULL
		AND

                      d1.cantidad_horas_1 is not NULL
		AND

				      d1.fecha_inicio_1 is not NULL
		AND
				      d1.fecha_finalizacion_1 is not NULL
		AND
                      d1.Pais_1 is not NULL
		AND

                      d1.diploma_obtenido_1 is not NULL
union all
	select
		d2.codigo_de_solicitante as [codigo_de_solicitante],
		d2.nombre_capacitacion_2 as [nombre_capacitacion],
		d2.cantidad_horas_2 as [cantidad_horas],
		d2.Institucion_2 as [institucion],
		d2.fecha_inicio_2 as [fecha_inicio],
		d2.fecha_finalizacion_2 as [fecha_finalizacion],
		d2.Pais_2 as [pais],
		d2.diploma_obtenido_2 as [diploma_obtenido],
		2 as [indice_capacitacion]
	from
		docentes_cv_all_rows d2
	WHERE
		d2.nombre_capacitacion_2 is not NULL
		AND

                      d2.Institucion_2 is NOT NULL
		AND

                      d2.cantidad_horas_2 is not NULL
		AND

				      d2.fecha_inicio_2 is not NULL
		AND
				      d2.fecha_finalizacion_2 is not NULL
		AND
                      d2.Pais_2 is not NULL
		AND

                      d2.diploma_obtenido_2 is not NULL
union all
	select
		d3.codigo_de_solicitante as [codigo_de_solicitante],
		d3.nombre_capacitacion_3 as [nombre_capacitacion],
		d3.cantidad_horas_3 as [cantidad_horas],
		d3.Institucion_3 as [institucion],
		d3.fecha_inicio_3 as [fecha_inicio],
		d3.fecha_finalizacion_3 as [fecha_finalizacion],
		d3.Pais_3 as [pais],
		d3.diploma_obtenido_3 as [diploma_obtenido],
		3 as [indice_capacitacion]
	from
		docentes_cv_all_rows d3
	WHERE
		d3.nombre_capacitacion_3 is not NULL
		AND

                      d3.Institucion_3 is NOT NULL
		AND

                      d3.cantidad_horas_3 is not NULL
		AND

				      d3.fecha_inicio_3 is not NULL
		AND
				      d3.fecha_finalizacion_3 is not NULL
		AND
                      d3.Pais_3 is not NULL
		AND

                      d3.diploma_obtenido_3 is not NULL
union all
	select
		d4.codigo_de_solicitante as [codigo_de_solicitante],
		d4.nombre_capacitacion_4 as [nombre_capacitacion],
		d4.cantidad_horas_4 as [cantidad_horas],
		d4.Institucion_4 as [institucion],
		d4.fecha_inicio_4 as [fecha_inicio],
		d4.fecha_finalizacion_4 as [fecha_finalizacion],
		d4.Pais_4 as [pais],
		d4.diploma_obtenido_4 as [diploma_obtenido],
		4 as [indice_capacitacion]
	from
		docentes_cv_all_rows d4
	WHERE
		d4.nombre_capacitacion_4 is not NULL
		AND

                      d4.Institucion_4 is NOT NULL
		AND

                      d4.cantidad_horas_4 is not NULL
		AND

				      d4.fecha_inicio_4 is not NULL
		AND
				      d4.fecha_finalizacion_4 is not NULL
		AND
                      d4.Pais_4 is not NULL
		AND

                      d4.diploma_obtenido_4 is not NULL
union all
	select
		d5.codigo_de_solicitante as [codigo_de_solicitante],
		d5.nombre_capacitacion_5 as [nombre_capacitacion],
		d5.cantidad_horas_5 as [cantidad_horas],
		d5.Institucion_5 as [institucion],
		d5.fecha_inicio_5 as [fecha_inicio],
		d5.fecha_finalizacion_5 as [fecha_finalizacion],
		d5.Pais_5 as [pais],
		d5.diploma_obtenido_5 as [diploma_obtenido],
		5 as [indice_capacitacion]
	from
		docentes_cv_all_rows d5
	WHERE
		d5.nombre_capacitacion_5 is not NULL
		AND

                      d5.Institucion_5 is NOT NULL
		AND

                      d5.cantidad_horas_5 is not NULL
		AND

				      d5.fecha_inicio_5 is not NULL
		AND
				      d5.fecha_finalizacion_5 is not NULL
		AND
                      d5.Pais_5 is not NULL
		AND

                      d5.diploma_obtenido_5 is not NULL

) as er


