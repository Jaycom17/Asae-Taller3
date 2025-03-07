package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Respuesta;

import java.util.ArrayList;
import java.util.Date;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.EnumEstado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoPPDTORespuesta extends FormatoDTORespuesta {
    private String asesor;
    private String cartaAceptacion;

    public FormatoPPDTORespuesta() {
    }

    public FormatoPPDTORespuesta(Integer id, Date fecha, EnumEstado estado, String titulo, String objetivoGeneral, String directorDelTrabajo, ArrayList<String> objetivos, String primerEstudiante, String asesor, String cartaAceptacion) {
        super(id, fecha, estado, titulo, objetivoGeneral, directorDelTrabajo, objetivos, primerEstudiante);
        this.asesor = asesor;
        this.cartaAceptacion = cartaAceptacion;
    }
}
