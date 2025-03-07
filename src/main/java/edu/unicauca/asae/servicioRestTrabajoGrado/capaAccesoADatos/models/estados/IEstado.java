package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoEntity;

public interface IEstado {
    Resultado cambiarEnFormulacion(FormatoEntity formato);
    Resultado cambiarEnEvaluacion(FormatoEntity formato);
    Resultado cambiarPorCorregir(FormatoEntity formato);
    Resultado cambiarAprobado(FormatoEntity formato);
    Resultado cambiarRechazado(FormatoEntity formato);
}
