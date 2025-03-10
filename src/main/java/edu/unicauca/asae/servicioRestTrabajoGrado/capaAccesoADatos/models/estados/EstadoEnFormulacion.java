package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados;


public class EstadoEnFormulacion implements IEstado {

    @Override
    public Resultado cambiarEnEvaluacion() {
        return new Resultado(true, "Se ha cambiado a en evaluación");
    }

    @Override
    public Resultado cambiarPorCorregir() {
        return new Resultado(false, "Un formato A en formulación no puede cambiar a por corregir");
    }

    @Override
    public Resultado cambiarAprobado() {
        return new Resultado(false, "Un formato A en formulación no puede cambiar a aprobado");
    }

    @Override
    public Resultado cambiarRechazado() {
        return new Resultado(false, "Un formato A en formulación no puede cambiar a rechazado");
    }

    @Override
    public Resultado cambiarEnFormulacion() {
        return new Resultado(false, "El formato ya se encuentra en formulación");
    }
    
}
