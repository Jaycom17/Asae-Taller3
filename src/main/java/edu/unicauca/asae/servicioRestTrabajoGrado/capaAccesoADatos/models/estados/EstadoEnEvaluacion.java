package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados;


public class EstadoEnEvaluacion implements IEstado {

    @Override
    public Resultado cambiarEnEvaluacion() {
        return new Resultado(false, "Un formati A en evaluación no puede cambiar a en evaluación");
    }

    @Override
    public Resultado cambiarPorCorregir() {
        return new Resultado(true, "Se ha cambiado a por corregir");
    }

    @Override
    public Resultado cambiarAprobado() {
        return new Resultado(true, "Se ha cambiado a aprobado");
    }

    @Override
    public Resultado cambiarRechazado() {
        return new Resultado(true, "Se ha cambiado a rechazado");
    }

    @Override
    public Resultado cambiarEnFormulacion() {
        return new Resultado(false, "Un formato A en evaluación no puede cambiar a en formulación");
    }
    
}
