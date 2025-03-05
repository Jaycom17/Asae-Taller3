package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models;

import java.sql.Date;
import java.util.ArrayList;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.IEstado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FormatoEntity {
    private Integer id;
    private Date fecha;
    private IEstado estado;
    private String titulo;
    private String objetivoGeneral;
    private String directorDelTrabajo;
    private ArrayList<String> objetivos;
    private String primerEstudiante;

    public FormatoEntity() {
    }
}
