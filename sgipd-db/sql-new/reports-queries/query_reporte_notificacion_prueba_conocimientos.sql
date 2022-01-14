select
	d.nombre as [DEPARTAMENTO],
	m.nombre as [MUNICIPIO],
	da.id_sigobsol_usuario as [Código de solicitante],
	cv.dui as [DUI],
	cv.nip as [NIP],
	cv.correo_e as [eCORREO],
	--Estudios aca
	dbo.obtenerEspecialidadByIdSigobSolUsuario(cv.id_sigobsol_usuario) as [ESPECIALIDAD],
	dbo.obtenerTituloByIdSigobSolUsuario(cv.id_sigobsol_usuario) as [TÍTULO],
	dbo.obtenerUniversidadByIdSigobSolUsuario(cv.id_sigobsol_usuario) as [UNIVERSIDAD],
	dbo.obtenerAnnioGraduacionByIdSigobSolUsuario(cv.id_sigobsol_usuario) as [AÑO GRADUACIÓN],
	cv.nombres + ' ' + cv.apellidos as [Nombre completo según registro de plataforma],
	cv.nombres as [Nombre],
	cv.apellidos as [Apellido],
	da.id_tramite_aplic as [ID de plaza vacante],
	p.nivel_educativo as [Nivel educativo],
	ce.nombrece as [Centro educativo de plaza],
	p.especialidad as [Especialidad de plaza vacantes]
FROM
	Docentes_aplicaciones da,
	Plazas p,
	Centros_educativos ce,
	Municipios m,
	Departamentos d,
	Docentes cv
WHERE
	da.id_secuencial_plaza = p.id_secuencial
	AND 
p.codinfra = ce.codinfra
	AND
ce.id_municipio = m.id
	AND
m.id_departamento = d.id
	AND
da.id_sigobsol_usuario = cv.id_sigobsol_usuario
	--AND
	--da.id_sigobsol_usuario = 8421
ORDER BY
	d.nombre ,
	m.nombre ;