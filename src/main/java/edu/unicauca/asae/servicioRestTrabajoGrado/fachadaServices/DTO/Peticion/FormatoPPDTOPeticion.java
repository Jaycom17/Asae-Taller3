package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Peticion;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoPPDTOPeticion extends FormatoDTOPeticion {
    private String asesor;
    private String cartaAceptacion;

    public FormatoPPDTOPeticion() {
    }

    public FormatoPPDTOPeticion(String titulo, String objetivoGeneral, String directorDelTrabajo, ArrayList<String> objetivos, String primerEstudiante, String asesor, String cartaAceptacion) {
        super(titulo, objetivoGeneral, directorDelTrabajo, objetivos, primerEstudiante);
        this.asesor = asesor;
        this.cartaAceptacion = cartaAceptacion;
    }
}
