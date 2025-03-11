package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.EnumEstado;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoEntity;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoPPEntity;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoTIEntity;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.estados.Resultado;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.repositories.FormatoRepository;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Peticion.FormatoDTOPeticion;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Peticion.FormatoPPDTOPeticion;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Peticion.FormatoTIDTOPeticion;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Respuesta.FormatoDTORespuesta;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Respuesta.FormatoPPDTORespuesta;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Respuesta.FormatoTIDTORespuesta;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.estado.Formato;

@Service("formatoService")
public class FormatoServiceImpl implements IFormatoService {

    @Qualifier("formatoRepository")
    private FormatoRepository formatoRepository;
    private ModelMapper modelMapper;

    public FormatoServiceImpl(FormatoRepository formatoRepository, ModelMapper modelMapper) {
        this.formatoRepository = formatoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FormatoDTORespuesta> getAll() {
        List<FormatoDTORespuesta> formatos = null;

		Optional<Collection<FormatoEntity>> formatosEntitiesRes = this.formatoRepository.findAll(); 

		if (formatosEntitiesRes.isEmpty()) {
			formatos = List.of();
		} else {
			Collection<FormatoEntity> formatosEntities = formatosEntitiesRes.get();
			formatos = formatosEntities.stream().map(formato -> {
                if (formato instanceof FormatoPPEntity) {
                    return this.modelMapper.map(formato, FormatoPPDTORespuesta.class);
                } else {
                    return this.modelMapper.map(formato, FormatoTIDTORespuesta.class);
                }
            }).toList();
		}
		return formatos;
    }

    @Override
    public FormatoDTORespuesta getById(Integer id) {
        FormatoDTORespuesta formato = null;

        Optional<FormatoEntity> formatoEntityRes = this.formatoRepository.findById(id);

        if (formatoEntityRes.isPresent()) {
            FormatoEntity formatoEntity = formatoEntityRes.get();
            formato = formatoEntity instanceof FormatoPPEntity ? this.modelMapper.map(formatoEntity, FormatoPPDTORespuesta.class) : this.modelMapper.map(formatoEntity, FormatoTIDTORespuesta.class);
        }

        return formato;
    }

    @Override
    public FormatoDTORespuesta save(FormatoDTOPeticion formato) {
        FormatoEntity formatoEntity;
        if (formato instanceof FormatoPPDTOPeticion) {
            formatoEntity = this.modelMapper.map(formato, FormatoPPEntity.class);
        } else {
            formatoEntity = this.modelMapper.map(formato, FormatoTIEntity.class);
        }
        
        FormatoEntity objFormatoEntity = this.formatoRepository.save(formatoEntity);
        
        FormatoDTORespuesta formatoDTO;
        if (objFormatoEntity instanceof FormatoPPEntity) {
            formatoDTO = this.modelMapper.map(objFormatoEntity, FormatoPPDTORespuesta.class);
        } else {
            formatoDTO = this.modelMapper.map(objFormatoEntity, FormatoTIDTORespuesta.class);
        }
        
        return formatoDTO;
    }

    @Override
    public FormatoDTORespuesta update(Integer id, FormatoDTOPeticion formato) {
        FormatoEntity formatoActualizado = null;
        Optional<FormatoEntity> formatoEntityRes = this.formatoRepository.findById(id);

        if (formatoEntityRes.isPresent()) {
            FormatoEntity formatoEntity = formatoEntityRes.get();


            formatoEntity.setTitulo(formato.getTitulo());
            formatoEntity.setObjetivoGeneral(formato.getObjetivoGeneral());
            formatoEntity.setDirectorDelTrabajo(formato.getDirectorDelTrabajo());
            formatoEntity.setObjetivos(formato.getObjetivos());
            formatoEntity.setPrimerEstudiante(formato.getPrimerEstudiante());

            if(formato instanceof FormatoPPDTOPeticion){
                ((FormatoPPEntity) formatoEntity).setAsesor(((FormatoPPDTOPeticion) formato).getAsesor());
                ((FormatoPPEntity) formatoEntity).setCartaAceptacion(((FormatoPPDTOPeticion) formato).getCartaAceptacion());
            }else{
                ((FormatoTIEntity) formatoEntity).setSegundoEstudiante(((FormatoTIDTOPeticion) formato).getSegundoEstudiante());
            }

            

            formatoActualizado = this.formatoRepository.update(id, formatoEntity).get();
        }

        return formato instanceof FormatoPPDTOPeticion ? this.modelMapper.map(formatoActualizado, FormatoPPDTORespuesta.class) : this.modelMapper.map(formatoActualizado, FormatoTIDTORespuesta.class);
    }

    @Override
    public String changeState(Integer id, EnumEstado state) {
        String result = "";
        FormatoEntity formatoActualizado = null;
        Optional<FormatoEntity> formatoEntityRes = this.formatoRepository.findById(id);

        if (formatoEntityRes.isPresent()) {
            formatoActualizado = formatoEntityRes.get();

            Formato formato = new Formato(formatoActualizado.getEstado());

            Resultado cambio = null;

            switch (state) {
                case EN_FORMULACION:
                    cambio = formato.getEstado().cambiarEnFormulacion();
                    break;
                case EN_EVALUACION:
                    cambio = formato.getEstado().cambiarEnEvaluacion();
                    break;
                case POR_CORREGIR:
                    cambio = formato.getEstado().cambiarPorCorregir();
                    break;
                case APROBADO:
                    cambio = formato.getEstado().cambiarAprobado();
                    break;
                case RECHAZADO:
                    cambio = formato.getEstado().cambiarRechazado();
                    break;
                default:
                    break;
            }

            result = cambio.mensaje();

            if (cambio.cambioPermitido()) {
                boolean auxResult = this.formatoRepository.changeState(id, state);

                if (!auxResult) {
                    result = "Ha ocurrido un error al cambiar el estado";
                }
            }


        }else {
            result = "No se encontró el formato";
        }

        return result;
    }

    @Override
    public List<FormatoDTORespuesta> getBetweenDates(String fechaInicio, String fechaFin) {
        List<FormatoDTORespuesta> formatos = null;

		Optional<Collection<FormatoEntity>> formatosEntitiesRes = this.formatoRepository.findAll();

        if (formatosEntitiesRes.isEmpty()) {
            formatos = List.of();
        } else {
            Collection<FormatoEntity> formatosEntities = formatosEntitiesRes.get();
            formatos = new ArrayList<>(formatosEntities.stream().map(formato -> {
                if (formato instanceof FormatoPPEntity) {
                    return this.modelMapper.map(formato, FormatoPPDTORespuesta.class);
                } else {
                    return this.modelMapper.map(formato, FormatoTIDTORespuesta.class);
                }
            }).toList());

            formatos.removeIf(formato -> formato.getFecha().before(java.sql.Date.valueOf(fechaInicio)) || formato.getFecha().after(java.sql.Date.valueOf(fechaFin)));
        }

        return formatos;
    }
    
}
