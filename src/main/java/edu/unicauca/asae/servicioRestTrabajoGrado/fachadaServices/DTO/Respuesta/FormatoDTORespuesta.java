package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Respuesta;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.EnumEstado;
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
  @JsonSubTypes.Type(value = FormatoPPDTORespuesta.class, name = "pp"),
  @JsonSubTypes.Type(value = FormatoTIDTORespuesta.class, name = "ti")
})
public abstract class FormatoDTORespuesta {
    private Integer id;
    private Date fecha;
    private EnumEstado estado;
    private String titulo;
    private String objetivoGeneral;
    private String directorDelTrabajo;
    private ArrayList<String> objetivos;
    private String primerEstudiante;

    public FormatoDTORespuesta() {
    }
}
