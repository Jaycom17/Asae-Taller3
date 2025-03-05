package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models;

import java.sql.Date;
import java.util.ArrayList;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.IEstado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoTIEntity extends FormatoEntity {

    private String segundoEstudiante;

    public FormatoTIEntity() {
    }

    public FormatoTIEntity(Integer id, Date fecha, IEstado estado, String titulo, String objetivoGeneral, String directorDelTrabajo, String primerEstudiante, ArrayList<String> objetivos, String segundoEstudiante) {
        super(id, fecha, estado, titulo, objetivoGeneral, directorDelTrabajo, objetivos, primerEstudiante);
        this.segundoEstudiante = segundoEstudiante;
    }
    
}
