select
    d.nip,
    d.nombres,
    d.apellidos,
    dbo.obtenerSexoByCodigoTramite(d.id_tramite) as 'Sexo',
    dbo.obtenerSiEsInterinoByCodigo2String(d.id_tramite) as 'Es Interino',
    d.departamento ,
    d.municipio
from
    Docentes d