package edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoEntity;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoPPEntity;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.repositories.FormatoRepository;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Peticion.FormatoDTOPeticion;
import edu.unicauca.asae.servicioRestTrabajoGrado.fachadaServices.DTO.Respuesta.FormatoDTORespuesta;

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
        FormatoEntity formatoEntity = this.modelMapper.map(formato, FormatoEntity.class);
		FormatoEntity objFormatoEntity = this.formatoRepository.save(formatoEntity);
		FormatoDTORespuesta clienteDTO = this.modelMapper.map(objFormatoEntity, FormatoDTORespuesta.class);
		return clienteDTO;
    }

    @Override
    public FormatoDTORespuesta update(Integer id, FormatoDTOPeticion formato) {
        FormatoEntity formatoActualizado = null;
        Optional<FormatoEntity> formatoEntityRes = this.formatoRepository.findById(id);

        if (formatoEntityRes.isPresent()) {
            FormatoEntity formatoEntity = formatoEntityRes.get();

            if(formatoEntity instanceof FormatoPPEntity){
                // updateFormatoEntity((FormatoEntity) formatoEntity, formato);
                // formatoActualizado = this.formatoRepository.update(id, formatoEntity).get();
            }//TODO: corregir todo

            formatoEntity.setTitulo(formato.getTitulo());
            formatoEntity.setObjetivoGeneral(formato.getObjetivoGeneral());
            formatoEntity.setDirectorDelTrabajo(formato.getDirectorDelTrabajo());
            formatoEntity.setObjetivos(formato.getObjetivos());
            formatoEntity.setPrimerEstudiante(formato.getPrimerEstudiante());
        }
    }

    @Override
    public boolean changeState(Integer id, String state) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<FormatoDTORespuesta> getBetweenDates(String fechaInicio, String fechaFin) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
