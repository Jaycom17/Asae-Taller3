package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoEntity;

public class EstadoRechazado implements IEstado {

    @Override
    public Resultado cambiarEnEvaluacion() {
        return new Resultado(false, "Un formato A rechazado no puede cambiar a en evaluación");
    }

    @Override
    public Resultado cambiarPorCorregir() {
        return new Resultado(false, "Un formato A rechazado no puede cambiar a por corregir");
    }

    @Override
    public Resultado cambiarAprobado() {
        return new Resultado(false, "Un formato A rechazado no puede cambiar a aprobado");
    }

    @Override
    public Resultado cambiarRechazado() {
        return new Resultado(false, "Un formato A rechazado no puede cambiar a rechazado");
    }

    @Override
    public Resultado cambiarEnFormulacion() {
        return new Resultado(false, "Un formato A rechazado no puede cambiar a en formulación");
    }
    
}
