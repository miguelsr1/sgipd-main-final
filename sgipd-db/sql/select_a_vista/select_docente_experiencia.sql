--Script para generar experiencia laboral
select
	er.*
FROM
	(
	select
		d1.codigo_de_solicitante as [codigo_de_solicitante],
		d1.institucion_educativa_nacional_1 as [institucion_educativa_nacional],
		d1.institucion_educativa_extranjero_1 as [institucion_educativa_extranjero],
		d1.cantidad_de_annios_1 as [cantidad_de_annios],
		d1.departamento_1 as [departamento],
		d1.municipio_1 as [municipio],
		d1.desde_1 as [desde],
		d1.hasta_1 as [hasta],
		d1.nombramiento_1 as [nombramiento],
		d1.sector_1 as [sector],		
		1 as [indice_experiencia]
	from
		docentes_cv_all_rows d1
	WHERE
               d1.cantidad_de_annios_1 is not NULL
		AND
		      d1.departamento_1 is not NULL
		AND
		      d1.municipio_1 is not NULL
		AND
                      d1.desde_1 is not NULL
		AND
                      d1.hasta_1 is NOT NULL
		AND
                      d1.nombramiento_1 is NOT NULL
		AND
                      d1.sector_1 is not NULL
union all
	select
		d2.codigo_de_solicitante as [codigo_de_solicitante],
		d2.institucion_educativa_nacional_2 as [institucion_educativa_nacional],
		d2.institucion_educativa_extranjero_2 as [institucion_educativa_extranjero],
		d2.cantidad_de_annios_2 as [cantidad_de_annios],
		d2.departamento_2 as [departamento],
		d2.municipio_2 as [municipio],
		d2.desde_2 as [desde],
		d2.hasta_2 as [hasta],
		d2.nombramiento_2 as [nombramiento],
		d2.sector_2 as [sector],		
		2 as [indice_experiencia]
	from
		docentes_cv_all_rows d2
	WHERE
		d2.cantidad_de_annios_2 is not NULL
		AND
		      d2.departamento_2 is not NULL
		AND
		      d2.municipio_2 is not NULL
		AND
                      d2.desde_2 is not NULL
		AND
                      d2.hasta_2 is NOT NULL
		AND
                      d2.nombramiento_2 is NOT NULL
		AND
                      d2.sector_2 is not NULL
union all
	select
		d3.codigo_de_solicitante as [codigo_de_solicitante],
		d3.institucion_educativa_nacional_3 as [institucion_educativa_nacional],
		d3.institucion_educativa_extranjero_3 as [institucion_educativa_extranjero],
		d3.cantidad_de_annios_3 as [cantidad_de_annios],
		d3.departamento_3 as [departamento],
		d3.municipio_3 as [municipio],
		d3.desde_3 as [desde],
		d3.hasta_3 as [hasta],
		d3.nombramiento_3 as [nombramiento],
		d3.sector_3 as [sector],		
		3 as [indice_experiencia]
	from
		docentes_cv_all_rows d3
	WHERE
		d3.cantidad_de_annios_3 is not NULL
		AND
		      d3.departamento_3 is not NULL
		AND
		      d3.municipio_3 is not NULL
		AND
                      d3.desde_3 is not NULL
		AND
                      d3.hasta_3 is NOT NULL
		AND
                      d3.nombramiento_3 is NOT NULL
		AND
                      d3.sector_3 is not NULL
union all
	select
		d4.codigo_de_solicitante as [codigo_de_solicitante],
		d4.institucion_educativa_nacional_4 as [institucion_educativa_nacional],
		d4.institucion_educativa_extranjero_4 as [institucion_educativa_extranjero],
		d4.cantidad_de_annios_4 as [cantidad_de_annios],
		d4.departamento_4 as [departamento],
		d4.municipio_4 as [municipio],
		d4.desde_4 as [desde],
		d4.hasta_4 as [hasta],
		d4.nombramiento_4 as [nombramiento],
		d4.sector_4 as [sector],		
		4 as [indice_experiencia]
	from
		docentes_cv_all_rows d4
	WHERE
		d4.cantidad_de_annios_4 is not NULL
		AND
		      d4.departamento_4 is not NULL
		AND
		      d4.municipio_4 is not NULL
		AND
                      d4.desde_4 is not NULL
		AND
                      d4.hasta_4 is NOT NULL
		AND
                      d4.nombramiento_4 is NOT NULL
		AND
                      d4.sector_4 is not NULL
		) as er







