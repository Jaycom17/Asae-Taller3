package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Peticion;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FormatoDTOPeticion {
	private String titulo;
    private String objetivoGeneral;
    private String directorDelTrabajo;
    private ArrayList<String> objetivos;
    private String primerEstudiante;

    public FormatoDTOPeticion() {
    }
}
