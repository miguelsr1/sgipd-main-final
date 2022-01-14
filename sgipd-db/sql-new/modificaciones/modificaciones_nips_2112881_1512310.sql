SELECT rdppad.*
into ReporteDocentesPruebaPsicometricaAll_Data_01_11_2021
from ReporteDocentesPruebaPsicometricaAll_Data rdppad

GO

select c.*
into Calificaciones_01_11_2021
from Calificaciones c

go

update ReporteDocentesPruebaPsicometricaAll_Data
set resultadospruebaconocimientos = 6.25,
    aprobacion                    =1
where nip = '2112881';


go


UPDATE Calificaciones
set valor_calif       = 6.25,
    valor_ponderacion = 0.25 * 6.25,
    aprobacion        = 1,
    estatus           = 'APROBADO',
    observacion       = 'RV: Modificación de en SIGOB de registro por omisión de calificación Básica.Sat 10/30/2021 6:32 PM'
WHERE id_tramite_aplic in (
    select rdppad.idTramite from ReporteDocentesPruebaPsicometricaAll_Data rdppad where rdppad.nip = '2112881'
);

go

INSERT INTO Calificaciones (id_tramite_aplic, id_criterio, valor_calif, valor_ponderacion, fecha_ingreso,
                            usuario_ingreso, fecha_actualizacion, usuario_actualizacion, aprobacion, estatus,
                            observacion)
SELECT da.id_tramite_aplic,
       2                                                                                                    as [id_criterio],
       6.50                                                                                                 as [valor_calif],
       6.50 * 0.25                                                                                          as [valor_ponderacion],
       GETDATE()                                                                                            as [fecha_ingreso],
       'melvin.henriquez'                                                                                   as [usuario_ingreso],
       GETDATE()                                                                                            as [fecha_actualizacion],
       'melvin.henriquez'                                                                                   as [usuario_actualizacion],
       1                                                                                                    as [aprobacion],
       'APROBADO'                                                                                           as [estatus],
       'RV: Modificación de en SIGOB de registro por omisión de calificación Básica.Sat 10/30/2021 2:03 PM' as [observacion]
from Docentes_aplicaciones da,
     Docentes d
WHERE da.id_sigobsol_usuario = d.id_sigobsol_usuario
  AND nip = '1512310'

GO

INSERT INTO ReporteDocentesPruebaPsicometricaAll_Data (idTramite, dui, nip, correo, especialidad, titulo,
                                                       nombreCompleto, nombres, apellidos, sexo, discapacidad,
                                                       codigoMunicipioResidencia, municipioderesidencia,
                                                       codigoDepartamentoResidencia, departamentoderesidencia,
                                                       direccionResidencia, idDePlazaVacante, nivelEducativo,
                                                       codigoinfracentroeducativo, centroEducativoDePlaza,
                                                       especialidadDePlazaVacantes, codigoDepartamentoPlaza,
                                                       departamentodelaplaza, codigomunicipio, municipiodelaplazas,
                                                       resultadospruebaconocimientos, aprobacion, docenteRechazado,
                                                       docenteAplicacionRechazada)
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
       p.nivel_educativo                                                  as [nivelEducativo],
       ce.codinfra                                                        as [codigoinfracentroeducativo],
       ce.nombrece                                                        as [centroEducativoDePlaza],
       p.especialidad                                                     as [especialidadDePlazaVacantes],
       d.id                                                               as [codigoDepartamentoPlaza],
       d.nombre                                                           as [departamentodelaplaza],
       m.id                                                               as [codigomunicipio],
       m.nombre                                                           as [municipiodelaplazas],
       cal.valor_calif                                                    as [resultadospruebaconocimientos],
       cal.aprobacion                                                     as [aprobacion],
       CASE
           when cv.rechazado = 'Rechazado'
               then 1
           else 0
           end                                                            as [docenteRechazado],
       CASE
           when da.rechazado = 'Rechazado'
               then 1
           else 0
           end                                                            as [docenteAplicacionRechazada]
       --INTO ReporteDocentesPruebaPsicometricaAll_Data
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
  AND cv.nip = '1512310'
ORDER BY d.nombre,
         m.nombre

GO
