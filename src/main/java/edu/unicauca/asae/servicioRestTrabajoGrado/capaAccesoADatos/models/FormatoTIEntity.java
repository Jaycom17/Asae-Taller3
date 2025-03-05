package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoTIEntity extends FormatoEntity {

    private String segundoEstudiante;

    public FormatoTIEntity() {
    }

    public FormatoTIEntity(Integer id, String titulo, String objetivoGeneral, String directorDelTrabajo, String primerEstudiante, ArrayList<String> objetivos, String segundoEstudiante) {
        super(id, titulo, objetivoGeneral, directorDelTrabajo, objetivos, primerEstudiante);
        this.segundoEstudiante = segundoEstudiante;
    }
    
}
