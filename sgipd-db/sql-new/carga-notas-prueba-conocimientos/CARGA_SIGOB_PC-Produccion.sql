--Paso 1 Eliminar tabla de tramite
DROP TABLE CARGA_SIGOB_PC ;

go

--Paso 2 crear tabla de tramite
CREATE TABLE CARGA_SIGOB_PC (
	ID_TRAMITE bigint NULL,
	NIP varchar(25) COLLATE Modern_Spanish_CI_AS NULL,
	ID_Plaza_Vacante bigint NULL,
	Nombre_completo varchar(1000) COLLATE Modern_Spanish_CI_AS NULL,
	NOTA_COGNITIVA decimal(10,2) NULL,
	ESTATUS varchar(25) COLLATE Modern_Spanish_CI_AS NULL,
	OBSERVACIONES varchar(2000) COLLATE Modern_Spanish_CI_AS NULL
);

--Paso 2.1 refrescar estructura de arbol para ir a paso 3
--Paso 2.2 cambiar headers de archivo C:\Users\xtecuan\Downloads\Carga-SIGOB-SOL\CARGA-SIGOB-26-10-2021.csv a 
--ID_TRAMITE,NIP,ID_Plaza_Vacante,Nombre_completo,NOTA_COGNITIVA,ESTATUS,OBSERVACIONES
--Archivo de salida C:\Users\xtecuan\Downloads\Carga-SIGOB-SOL\CARGA-SIGOB-26-10-2021-headers-cambiados.csv

go
--TRUNCATE table CARGA_SIGOB_PC 
--Paso 3 Cargar Archivo Proporcionado
-- C:\Users\xtecuan\Downloads\Carga-SIGOB-SOL\CARGA-SIGOB-26-10-2021-headers-cambiados.csv
-- Se modifico en las notas donde venia ,  -    , por ,,

go

--Paso 4 conteo de verificacion
select COUNT(*) from CARGA_SIGOB_PC csp 
--298968

go
--Paso 4.1
--Borrar Registros previos
--delete from Calificaciones ;

go
--Paso 5 Carga de datos en tabla de Calificaciones para Criterio 2 prueba de conocimientos

INSERT INTO Calificaciones (id_tramite_aplic, id_criterio, valor_calif, valor_ponderacion, 
                                              fecha_ingreso, usuario_ingreso, fecha_actualizacion, usuario_actualizacion, 
                                             aprobacion, estatus, observacion)
select csp.ID_TRAMITE as [id_tramite_aplic],
       2 as [id_criterio],
       csp.NOTA_COGNITIVA as [valor_calif],
       csp.NOTA_COGNITIVA * 0.25 as [valor_ponderacion],
       GETDATE() as [fecha_ingreso] ,
       'melvin.henriquez' as [usuario_ingreso],
        GETDATE() as [fecha_actualizacion] ,
       'melvin.henriquez' as [usuario_actualizacion],
       CASE    WHEN csp.ESTATUS = 'APROBADO'
                           THEN 1
                       ELSE 0
                       END             as [aprobacion],
       csp.ESTATUS  as [estatus],
       csp.OBSERVACIONES  as [observacion]
from CARGA_SIGOB_PC csp 


go

--Paso 6 conteo de verificacion
select COUNT(*) from Calificaciones c where c.id_criterio =2

--298968
go
--Paso 6.1 borrar tabla tabla de resumen del criterio 2 para usar en el criterio 1
DROP TABLE ReporteDocentesPruebaPsicometricaAll_Data;

GO 

--Paso 7 crear tabla de resumen del criterio 2 para usar en el criterio 1 
--Para generar el listado de docentes que se haran la prueba psicometrica

SELECT da.id_tramite_aplic                                                as [idTramite],
                   cv.dui                                                             as [dui],
                   cv.nip                                                             as [nip],
                   cv.correo_e                                                        as [correo],
                   dbo.obtenerEspecialidadByIdSigobSolUsuario(cv.id_sigobsol_usuario) as [especialidad],
                   dbo.obtenerTituloByIdSigobSolUsuario(cv.id_sigobsol_usuario)       as [titulo],
                   ISNULL(cv.nombres + ' ' + cv.apellidos,
                          cv.apellidos)                                               as [nombreCompleto],
                   cv.nombres                                                         as [nombres],
                   cv.apellidos                                                       as [apellidos],
                   dbo.obtenerSexoByCodigoTramite(cv.id_tramite)                      as [sexo],
                   ISNULL(cv.discapacidad, 'Ninguna')                                 as [discapacidad],
                   m2.id                                                              as [codigoMunicipioResidencia],
                   CASE
                       WHEN m2.nombre <> 'No Definido'
                           THEN m2.nombre
                       ELSE cv.municipio
                       END                                                            as [municipioderesidencia],
                   d2.id                                                              as [codigoDepartamentoResidencia],
                   CASE
                       WHEN d2.nombre <> 'No Definido'
                           THEN d2.nombre
                       ELSE cv.departamento
                       END                                                            as [departamentoderesidencia],
                   cv.direccion_postal                                                as [direccionResidencia],
                   p.id_secuencial                                                    as [idDePlazaVacante],
                   p.nivel_educativo 												  as [nivelEducativo],
                   ce.codinfra                                                        as [codigoinfracentroeducativo],
                   ce.nombrece                                                        as [centroEducativoDePlaza],
                   p.especialidad                                                     as [especialidadDePlazaVacantes],
                   d.id                                                               as [codigoDepartamentoPlaza],
                   d.nombre                                                           as [departamentodelaplaza],
                   m.id                                                               as [codigomunicipio],
                   m.nombre                                                           as [municipiodelaplazas],
                   cal.valor_calif                                                    as [resultadospruebaconocimientos],
                   cal.aprobacion 													  as [aprobacion],
                   CASE when cv.rechazado = 'Rechazado'
                        then 1
                        else 0
                        end                                                           as [docenteRechazado],
                   CASE when da.rechazado ='Rechazado'
                        then 1
                        else 0
                        end                                                           as [docenteAplicacionRechazada]
                   INTO ReporteDocentesPruebaPsicometricaAll_Data
            FROM Docentes_aplicaciones da,
                 Plazas p,
                 Centros_educativos ce,
                 Municipios m,
                 Municipios m2,
                 Departamentos d,
                 Departamentos d2,
                 Docentes cv,
                 Calificaciones cal
            WHERE da.id_secuencial_plaza = p.id_secuencial
              AND p.codinfra = ce.codinfra
              AND ce.id_municipio = m.id
              AND m.id_departamento = d.id
              AND da.id_sigobsol_usuario = cv.id_sigobsol_usuario
              AND da.id_tramite_aplic = cal.id_tramite_aplic
              AND cv.id_municipio = m2.id
              AND m2.id_departamento = d2.id
              AND cal.id_criterio = 2
              --AND cal.observacion ='FROM Registros_Calificaciones_Desde_Aplic_Rech'
              --AND cal.aprobacion = 1
              --AND cv.rechazado = 'No Rechazado'
              --AND da.rechazado ='No Rechazado'
            ORDER BY d.nombre,
                     m.nombre

GO 
--Paso 8 Conteo de verificacion de tabla resumen

SELECT COUNT(*) from ReporteDocentesPruebaPsicometricaAll_Data rdppad 
--298968
GO 
--Paso 9 asignar llave primaria a tabla de resumen
ALTER TABLE ReporteDocentesPruebaPsicometricaAll_Data ADD CONSTRAINT ReporteDocentesPruebaPsicometricaAll_Data_PK PRIMARY KEY (idTramite);


Go

--Paso 10 Listado de docentes aprobados en prueba de conocimientos que pueden realizar la prueba psicometrica

 SELECT DISTINCT nip,dui, correo, especialidad, titulo, nombreCompleto, nombres, apellidos, sexo, discapacidad, codigoMunicipioResidencia, municipioderesidencia, codigoDepartamentoResidencia, departamentoderesidencia, direccionResidencia from ReporteDocentesPruebaPsicometricaAll_Data
            WHERE aprobacion =1 AND docenteRechazado = 0 AND docenteAplicacionRechazada = 0

go


 SELECT
	DISTINCT r.nip,
	da.id_sigobsol_usuario as [codigo_solicitante],
	r.nombreCompleto,
	r.dui,
	dbo.obtenerEdadByIdUsuarioSIGOBSOL(da.id_sigobsol_usuario) as [edad],
	'' as [origen],
	isNull(r.municipioderesidencia,dbo.getCiudadDomicilioFromSIGOBUsuarios(da.id_sigobsol_usuario)) as [municipio],
	isNull(r.departamentoderesidencia,dbo.getDepartamentoDomicilioFromSIGOBUsuarios(da.id_sigobsol_usuario)) as [departamento],
	r.direccionResidencia as [domicilio],
	CASE WHEN dbo.obtenerEstadoCivil(da.id_sigobsol_usuario) = 'S'
	THEN 'Soltero'
	ELSE 'Casado'
	END as [Estado_Familiar]
from
	ReporteDocentesPruebaPsicometricaAll_Data r, Docentes_aplicaciones da 
WHERE
	r.idTramite = da.id_tramite_aplic 
	AND r.aprobacion = 1
	AND r.docenteRechazado = 0
	AND r.docenteAplicacionRechazada = 0
	--AND r.municipioderesidencia is null
	ORDER by 7,6
	

GO 

SELECT * from SGIDTPVD.dbo.Datos_para_pgr dpp ORDER by 7,6

GO 

SELECT 
    DISTINCT r.nip,
	r.nombreCompleto,
	r.dui,
	dbo.obtenerFechaDeNacimiento(da.id_sigobsol_usuario) as [fechaNacimiento],
	dbo.obtenerEdadByIdUsuarioSIGOBSOL(da.id_sigobsol_usuario) as [edad]
from
	ReporteDocentesPruebaPsicometricaAll_Data r, Docentes_aplicaciones da 
WHERE
	r.idTramite = da.id_tramite_aplic 
	AND r.aprobacion = 1
	AND r.docenteRechazado = 0
	AND r.docenteAplicacionRechazada = 0
	AND r.dui in (
	'02759515-7',  '04123799-1','008892760','04324265-9','029991189','04343664-9','04973794-5','030420387','04082523-8','048336314','05737196-5','04042334-5','00700402-1'
	)


GO 

SELECT id_sigobsol_usuario from Docentes d where d.nip in ('2111673','1802551')
--367 18030
GO 

Select u.domicilio_ciudad 
 from SOL_MINED_SV_PROD.dbo.usuario_sistema_tramite u
 where u.tipo_usuario = 1 AND u.codigo_usuario = :id_sigobsol_usuario;

GO 
