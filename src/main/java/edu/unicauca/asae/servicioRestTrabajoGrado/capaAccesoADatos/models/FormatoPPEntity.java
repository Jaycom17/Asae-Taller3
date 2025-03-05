package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoPPEntity extends FormatoEntity {
    private String asesor;
    private String cartaAceptacion;

    public FormatoPPEntity() {
    }

    public FormatoPPEntity(Integer id, String titulo, String objetivoGeneral, String directorDelTrabajo, String primerEstudiante, ArrayList<String> objetivos, String asesor, String cartaAceptacion) {
        super(id, titulo, objetivoGeneral, directorDelTrabajo, objetivos, primerEstudiante);
        this.asesor = asesor;
        this.cartaAceptacion = cartaAceptacion;
    }

}
