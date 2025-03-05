package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.estado;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.EnumEstado;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.EstadoAprovado;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.EstadoEnEvaluacion;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.EstadoEnFormulacion;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.EstadoPorCorregir;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.EstadoRechazado;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.IEstado;
import lombok.Getter;

@Getter
public class Formato {
    private IEstado estado;

    public Formato(EnumEstado estado) {
        switch (estado) {
            case EN_FORMULACION:
                this.estado = new EstadoEnFormulacion();
                break;
            case EN_EVALUACION:
                this.estado = new EstadoEnEvaluacion();
                break;
            case POR_CORREGIR:
                this.estado = new EstadoPorCorregir();
                break;
            case APROBADO:
                this.estado = new EstadoAprovado();
                break;
            case RECHAZADO:
                this.estado = new EstadoRechazado();
                break;
            default:
                break;
        }
    }

    
}
