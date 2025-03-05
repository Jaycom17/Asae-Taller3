package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Peticion;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoTIDTOPeticion extends FormatoDTOPeticion {
    private String segundoEstudiante;


    public FormatoTIDTOPeticion() {
    }

    
    public FormatoTIDTOPeticion(String titulo, String objetivoGeneral, String directorDelTrabajo, ArrayList<String> objetivos, String primerEstudiante, String segundoEstudiante) {
        super(titulo, objetivoGeneral, directorDelTrabajo, objetivos, primerEstudiante);
        this.segundoEstudiante = segundoEstudiante;
    }
}
