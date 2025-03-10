package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoEntity;

public interface IEstado {
    Resultado cambiarEnFormulacion();
    Resultado cambiarEnEvaluacion();
    Resultado cambiarPorCorregir();
    Resultado cambiarAprobado();
    Resultado cambiarRechazado();
}
