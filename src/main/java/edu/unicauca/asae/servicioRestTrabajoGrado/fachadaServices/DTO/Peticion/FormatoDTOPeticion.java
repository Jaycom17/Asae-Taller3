package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Peticion;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type"
)
@JsonSubTypes({
  @JsonSubTypes.Type(value = FormatoPPDTOPeticion.class, name = "pp"),
  @JsonSubTypes.Type(value = FormatoTIDTOPeticion.class, name = "ti")
})
public abstract class FormatoDTOPeticion {
	private String titulo;
    private String objetivoGeneral;
    private String directorDelTrabajo;
    private ArrayList<String> objetivos;
    private String primerEstudiante;

    public FormatoDTOPeticion() {
    }
}
