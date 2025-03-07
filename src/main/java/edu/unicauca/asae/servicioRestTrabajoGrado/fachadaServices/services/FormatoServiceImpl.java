package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
			formatos = this.modelMapper.map(formatosEntities, new TypeToken<List<FormatoDTORespuesta>>() {
			}.getType());
		}
		return formatos;
    }

    @Override
    public FormatoDTORespuesta getById(Integer id) {
        FormatoDTORespuesta formato = null;

        Optional<FormatoEntity> formatoEntityRes = this.formatoRepository.findById(id);

        if (formatoEntityRes.isPresent()) {
            FormatoEntity formatoEntity = formatoEntityRes.get();
            formato = this.modelMapper.map(formatoEntity, FormatoDTORespuesta.class);
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

            System.out.println("hola");

            formatoEntity.setTitulo(formato.getTitulo());
            formatoEntity.setObjetivoGeneral(formato.getObjetivoGeneral());
            formatoEntity.setDirectorDelTrabajo(formato.getDirectorDelTrabajo());
            formatoEntity.setObjetivos(formato.getObjetivos());
            formatoEntity.setPrimerEstudiante(formato.getPrimerEstudiante());
            System.out.println("hola");

            //TODO: revisar
            if(formato instanceof FormatoPPDTOPeticion){
                ((FormatoPPEntity) formatoEntity).setAsesor(((FormatoPPDTOPeticion) formato).getAsesor());
                ((FormatoPPEntity) formatoEntity).setCartaAceptacion(((FormatoPPDTOPeticion) formato).getCartaAceptacion());
            }else{
                ((FormatoTIEntity) formatoEntity).setSegundoEstudiante(((FormatoTIDTOPeticion) formato).getSegundoEstudiante());
            }

            
            System.out.println("hola");

            formatoActualizado = this.formatoRepository.update(id, formatoEntity).get();
        }

        return this.modelMapper.map(formatoActualizado, FormatoDTORespuesta.class);
    }

    @Override
    public boolean changeState(Integer id, EnumEstado state) {
        boolean result = false;
        FormatoEntity formatoActualizado = null;
        Optional<FormatoEntity> formatoEntityRes = this.formatoRepository.findById(id);

        if (formatoEntityRes.isPresent()) {
            formatoActualizado = formatoEntityRes.get();

            Formato formato = new Formato(formatoActualizado.getEstado());

            Resultado cambio = null;

            switch (state) {
                case EN_FORMULACION:
                    cambio = formato.getEstado().cambiarEnFormulacion(formatoActualizado);
                    break;
                case EN_EVALUACION:
                    cambio = formato.getEstado().cambiarEnEvaluacion(formatoActualizado);
                    break;
                case POR_CORREGIR:
                    cambio = formato.getEstado().cambiarPorCorregir(formatoActualizado);
                    break;
                case APROBADO:
                    cambio = formato.getEstado().cambiarAprobado(formatoActualizado);
                    break;
                case RECHAZADO:
                    cambio = formato.getEstado().cambiarRechazado(formatoActualizado);
                    break;
                default:
                    break;
            }

            if (cambio.cambioPermitido()) {
                result = this.formatoRepository.changeState(id, state);
            }

        }else {
            result = false;
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
            formatos = this.modelMapper.map(formatosEntities, new TypeToken<List<FormatoDTORespuesta>>() {
            }.getType());

            formatos.removeIf(formato -> formato.getFecha().before(java.sql.Date.valueOf(fechaInicio)) || formato.getFecha().after(java.sql.Date.valueOf(fechaFin)));
        }

        return formatos;
    }
    
}
