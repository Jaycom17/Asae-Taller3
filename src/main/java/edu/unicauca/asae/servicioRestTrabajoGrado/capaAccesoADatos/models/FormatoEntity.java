package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.IEstado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class FormatoEntity {
    IEstado estado;
}
