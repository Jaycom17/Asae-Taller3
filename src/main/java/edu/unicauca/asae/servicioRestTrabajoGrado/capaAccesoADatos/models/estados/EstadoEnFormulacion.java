package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoEntity;

public class EstadoEnFormulacion implements IEstado {

    @Override
    public Resultado cambiarEnEvaluacion(FormatoEntity formato) {
        EstadoEnEvaluacion estado = new EstadoEnEvaluacion();
        formato.setEstado(estado);
        return new Resultado(true, "Se ha cambiado a en evaluación");
    }

    @Override
    public Resultado cambiarPorCorregir(FormatoEntity formato) {
        return new Resultado(false, "Un formato A en formulación no puede cambiar a por corregir");
    }

    @Override
    public Resultado cambiarAprobado(FormatoEntity formato) {
        return new Resultado(false, "Un formato A en formulación no puede cambiar a aprobado");
    }

    @Override
    public Resultado cambiarRechazado(FormatoEntity formato) {
        return new Resultado(false, "Un formato A en formulación no puede cambiar a rechazado");
    }
    
}
