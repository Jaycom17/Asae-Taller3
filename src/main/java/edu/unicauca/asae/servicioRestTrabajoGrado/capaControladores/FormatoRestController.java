package edu.unicauca.asae.servicioRestTrabajoGrado.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.EnumEstado;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Peticion.FormatoDTOPeticion;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Respuesta.FormatoDTORespuesta;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.services.IFormatoService;

@RestController
@RequestMapping("/api")
public class FormatoRestController {
    
    @Autowired
    @Qualifier("formatoService")
    private IFormatoService formatoService;

    @GetMapping("/formato")
	public List<FormatoDTORespuesta> listarFormato() {
		return formatoService.getAll();
	}

	@GetMapping("/formato/{id}")
	public FormatoDTORespuesta consultarFormato(@PathVariable Integer id) {
		FormatoDTORespuesta objFormato = null;
		objFormato = formatoService.getById(id);
		return objFormato;
	}

	@GetMapping("formato/betweenDates/{fechaInicio}/{fechaFin}")
	public List<FormatoDTORespuesta> getBetweenDates(@PathVariable String fechaInicio,
			@PathVariable String fechaFin) {
		return formatoService.getBetweenDates(fechaInicio, fechaFin);
	}

	@PostMapping("/formato")
	public FormatoDTORespuesta crearFormato(@RequestBody FormatoDTOPeticion formato) {
		FormatoDTORespuesta objFormato = formatoService.save(formato);
		return objFormato;
	}

	@PutMapping("/formato/{id}")
	public FormatoDTORespuesta actualizarFormato(@RequestBody FormatoDTOPeticion formato, @PathVariable Integer id) {
		return formatoService.update(id, formato);
	}

	@PatchMapping("/formato/changestate/{id}/{estado}")
	public Boolean cambiarEstado(@PathVariable Integer id, @PathVariable EnumEstado estado) {
		return formatoService.changeState(id, estado);
	}
}
