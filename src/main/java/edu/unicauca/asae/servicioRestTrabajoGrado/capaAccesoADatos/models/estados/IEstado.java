package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados;


public interface IEstado {
    Resultado cambiarEnFormulacion();
    Resultado cambiarEnEvaluacion();
    Resultado cambiarPorCorregir();
    Resultado cambiarAprobado();
    Resultado cambiarRechazado();
}
