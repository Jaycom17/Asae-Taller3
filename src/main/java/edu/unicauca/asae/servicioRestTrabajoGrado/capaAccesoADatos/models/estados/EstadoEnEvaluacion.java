package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoEntity;

public class EstadoEnEvaluacion implements IEstado {

    @Override
    public Resultado cambiarEnEvaluacion(FormatoEntity formato) {
        return new Resultado(false, "Un formati A en evaluación no puede cambiar a en evaluación");
    }

    @Override
    public Resultado cambiarPorCorregir(FormatoEntity formato) {
        EstadoPorCorregir estado = new EstadoPorCorregir();
        formato.setEstado(estado);
        return new Resultado(true, "Se ha cambiado a por corregir");
    }

    @Override
    public Resultado cambiarAprobado(FormatoEntity formato) {
        EstadoAprovado estado = new EstadoAprovado();
        formato.setEstado(estado);
        return new Resultado(true, "Se ha cambiado a aprobado");
    }

    @Override
    public Resultado cambiarRechazado(FormatoEntity formato) {
        EstadoRechazado estado = new EstadoRechazado();
        formato.setEstado(estado);
        return new Resultado(true, "Se ha cambiado a rechazado");
    }
    
}
