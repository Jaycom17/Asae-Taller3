package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Respuesta;

import java.util.ArrayList;
import java.util.Date;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.EnumEstado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoTIDTORespuesta extends FormatoDTORespuesta {
    private String segundoEstudiante;

    public FormatoTIDTORespuesta() {
    }

    public FormatoTIDTORespuesta(Integer id, Date fecha, EnumEstado estado, String titulo, String objetivoGeneral, String directorDelTrabajo, ArrayList<String> objetivos, String primerEstudiante, String segundoEstudiante) {
        super(id, fecha, estado, titulo, objetivoGeneral, directorDelTrabajo, objetivos, primerEstudiante);
        this.segundoEstudiante = segundoEstudiante;
    }
}
