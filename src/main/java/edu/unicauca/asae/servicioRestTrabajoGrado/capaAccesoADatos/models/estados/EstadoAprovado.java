package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoEntity;

public class EstadoAprovado implements IEstado {

    @Override
    public Resultado cambiarEnEvaluacion(FormatoEntity formato) {
        return new Resultado(false, "Un formato A aprobado no puede cambiar a en evaluación");
    }

    @Override
    public Resultado cambiarPorCorregir(FormatoEntity formato) {
        return new Resultado(false, "Un formato A aprobado no puede cambiar a por corregir");
    }

    @Override
    public Resultado cambiarAprobado(FormatoEntity formato) {
        return new Resultado(false, "Un formato A aprobado no puede cambiar a aprobado");
    }

    @Override
    public Resultado cambiarRechazado(FormatoEntity formato) {
        return new Resultado(false, "Un formato A aprobado no puede cambiar a rechazado");
    }
    
}
