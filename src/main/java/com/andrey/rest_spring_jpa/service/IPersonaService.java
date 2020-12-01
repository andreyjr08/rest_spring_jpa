package com.andrey.rest_spring_jpa.service;

import com.andrey.rest_spring_jpa.dto.PersonaDto;
import java.util.List;

/**
 *
 * @author Desarrollo
 */
public interface IPersonaService {

    public List<PersonaDto> obtenerPersonas();

    public PersonaDto crearPersona(PersonaDto personaDto);

    public PersonaDto actualizarPersona(PersonaDto personaDto);

    public PersonaDto actualizarEstadoPersona(Integer idPersona);

}
