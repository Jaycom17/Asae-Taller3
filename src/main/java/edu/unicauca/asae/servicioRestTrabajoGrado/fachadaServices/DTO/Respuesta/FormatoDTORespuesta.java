package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Respuesta;

import java.util.ArrayList;
import java.util.Date;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.EnumEstado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FormatoDTORespuesta {
    private Integer id;
    private Date fecha;
    private EnumEstado datoEstado;
    private String titulo;
    private String objetivoGeneral;
    private String directorDelTrabajo;
    private ArrayList<String> objetivos;
    private String primerEstudiante;

    public FormatoDTORespuesta() {
    }
}
