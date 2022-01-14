package sv.gob.mined.projects.sgipd.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SGIPDJobsEnum {
    criterio3a(1, "criterio3a"), criterio3b(2, "criterio3b"), criterio4a(3, "criterio4a"),
    criterio4b(4, "criterio4a"), criterio5(5, "criterio5"),
    etldocentecapacitacion(6, "etldocentecapacitacion"), evaluardocentecapacitacion(7, "evaluardocentecapacitacion"),
    evaluardocenteestudio(8, "evaluardocenteestudio"), etldocenteexperiencia(9, "etldocenteexperiencia"),
    etldocenteestudio(10, "etldocenteestudio"), etl(11, "etl"),
    criterios(12, "criterios"), cierre(13, "cierre"),
    clasificacionelegibles(14, "clasificacionelegibles"), clasificacionnoelegibles(15, "clasificacionnoelegibles"),
    clasificacionporplaza(16, "clasificacionporplaza"),
    docenteplaza(17, "docenteplaza"),
    sigobsolaprobados(18,"sigobsolaprobados"),
    docentenoplaza(19, "docentenoplaza"),
    sigobsolreprobados(20,"sigobsolreprobados");


    private Integer id;
    private String nombre;
    private List<SGIPDJobsEnum> lista = new ArrayList<>();

    private SGIPDJobsEnum(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static SGIPDJobsEnum findById(Integer id) {
        return Arrays.stream(SGIPDJobsEnum.values()).filter(e -> e.getId().equals(id)).collect(Collectors.toList()).get(0);
    }
}
