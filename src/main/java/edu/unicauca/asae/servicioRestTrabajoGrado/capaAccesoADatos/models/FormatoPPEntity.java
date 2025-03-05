package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models;

import java.sql.Date;
import java.util.ArrayList;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.IEstado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoPPEntity extends FormatoEntity {
    private String asesor;
    private String cartaAceptacion;

    public FormatoPPEntity() {
    }

    public FormatoPPEntity(Integer id, Date fecha, IEstado estado, String titulo, String objetivoGeneral, String directorDelTrabajo, String primerEstudiante, ArrayList<String> objetivos, String asesor, String cartaAceptacion) {
        super(id, fecha, estado, titulo, objetivoGeneral, directorDelTrabajo, objetivos, primerEstudiante);
        this.asesor = asesor;
        this.cartaAceptacion = cartaAceptacion;
    }

}
