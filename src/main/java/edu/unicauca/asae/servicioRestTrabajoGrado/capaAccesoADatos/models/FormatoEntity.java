package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models;

import java.util.Date;
import java.util.ArrayList;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.EstadoEnFormulacion;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.IEstado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoEntity {
    private Integer id;
    private Date fecha;
    private EnumEstado datoEstado;
    private String titulo;
    private String objetivoGeneral;
    private String directorDelTrabajo;
    private ArrayList<String> objetivos;
    private String primerEstudiante;

    public FormatoEntity() {
    }

    public FormatoEntity(Integer id, String titulo, String objetivoGeneral, String directorDelTrabajo, ArrayList<String> objetivos, String primerEstudiante) {
        this.id = id;
        this.datoEstado = EnumEstado.EN_FORMULACION;
        this.fecha = new Date();
        this.titulo = titulo;
        this.objetivoGeneral = objetivoGeneral;
        this.directorDelTrabajo = directorDelTrabajo;
        this.objetivos = objetivos;
        this.primerEstudiante = primerEstudiante;
    }
}
