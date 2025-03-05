package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.services;

import java.util.List;

import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Peticion.FormatoDTOPeticion;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Respuesta.FormatoDTORespuesta;

public interface IFormatoService {
    public List<FormatoDTORespuesta> getAll();
    public FormatoDTORespuesta getById(Integer id);
    public FormatoDTORespuesta save(FormatoDTOPeticion formato);
    public FormatoDTORespuesta update(Integer id, FormatoDTOPeticion formato);
    public boolean changeState(Integer id, String state);
    public List<FormatoDTORespuesta> getBetweenDates(String fechaInicio, String fechaFin);
}
