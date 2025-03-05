package edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoEntity;
import edu.unicauca.asae.servicioRestTrabajoGrado.capaAccesoADatos.models.FormatoPPEntity;

@Repository("formatoRepository")
public class FormatoRepository {
    private Map<Integer, FormatoEntity> mapaFormatos;

    public FormatoRepository() {
        this.mapaFormatos = new HashMap<>();
        cargarFormatos();
    }

    public Optional<Collection<FormatoEntity>> findAll() {
        
        return mapaFormatos.isEmpty() ? Optional.empty() : Optional.of(mapaFormatos.values());
    }

    public Optional<FormatoEntity> findById(Integer id) {
        return Optional.ofNullable(mapaFormatos.get(id));
    }

    public FormatoEntity save(FormatoEntity formato) {
        this.mapaFormatos.put(formato.getId(), formato);
        return formato;
    }

    public Optional<FormatoEntity> update(Integer id, FormatoEntity formato) {
        Optional<FormatoEntity> respuesta;
        if (this.mapaFormatos.containsKey(id)) {
            this.mapaFormatos.put(id, formato);
            respuesta= Optional.of(formato);
        }
        else{
            respuesta= Optional.empty();
        }
       
		return respuesta;
    }

    private void cargarFormatos(){
        mapaFormatos.put(1, new FormatoPPEntity(1, "un trabajo bien melo", "un objetivo bien melo", "un director bien melo", "un estudiante bien melo", null, "un asesor bien melo", "una carta bien mela"));
    }
}
