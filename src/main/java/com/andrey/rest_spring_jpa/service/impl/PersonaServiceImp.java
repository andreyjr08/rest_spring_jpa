package com.andrey.rest_spring_jpa.service.impl;

import com.andrey.rest_spring_jpa.dto.PersonaDto;
import com.andrey.rest_spring_jpa.respository.IPersonaRepositoryJpa;
import com.andrey.rest_spring_jpa.service.IPersonaService;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
public class PersonaServiceImp implements IPersonaService {

    private final IPersonaRepositoryJpa iPersonaRepositoryJpa;

    @Autowired
    public PersonaServiceImp(IPersonaRepositoryJpa iPersonaRepositoryJpa) {
        this.iPersonaRepositoryJpa = iPersonaRepositoryJpa;
    }

    @Override
    public List<PersonaDto> obtenerPersonas() {
        log.info("[{}]- consultando personas, message{}..", Thread.currentThread().getId());
        return iPersonaRepositoryJpa.obtenerPersonas();
    }
    
    @Transactional
    @Override
    public PersonaDto crearPersona(PersonaDto personaDto) {
        try {
            personaDto.setEstado("A");
            iPersonaRepositoryJpa.crearPersona(
                    personaDto.getNombre(),
                    personaDto.getApellido(),
                    personaDto.getFechanacimiento(),
                    personaDto.getTelefono(),
                    personaDto.getDireccion(),
                    personaDto.getEstado()
            );

            log.info("[{}] La persona ha sido creada correctamente: {}", Thread.currentThread().getId(), personaDto);
        } catch (Exception e) {
            e.getMessage();
            log.error("[{}] Error al crear la persona: {}, message: {} ", Thread.currentThread().getId(), personaDto);
        }
        return personaDto;
    }
    
    public PersonaDto actualizarPersona(PersonaDto personaDto) {
        try {
            iPersonaRepositoryJpa.actualizarPersona(
                    personaDto.getNombre(),
                    personaDto.getApellido(),
                    personaDto.getFechanacimiento(),
                    personaDto.getTelefono(),
                    personaDto.getDireccion(),
                    personaDto.getId()
            );
            log.info("[{}] La persona ha sido actualizada correctamente: {}", Thread.currentThread().getId(), personaDto);
        } catch (Exception e) {
            e.getMessage();
            log.error("[{}] Error al actualizar la persona: {}, message: {} ", Thread.currentThread().getId(), personaDto);
        }
        return personaDto;
    }
    
    @Transactional
    @Override
    public PersonaDto actualizarEstadoPersona(Integer idPersona) {
        PersonaDto personaDto = new PersonaDto();
        try {
            personaDto = iPersonaRepositoryJpa.obtenerPersona(idPersona);
            personaDto.setEstado(personaDto.getEstado().equals("A") ? "I" : "A");
            iPersonaRepositoryJpa.actualizarEstadoPersona(personaDto.getEstado(), idPersona);
            log.info("[{}] El estado de la persona ha sido actualizado correctamente: {}", Thread.currentThread().getId(), personaDto);
        } catch (Exception e) {
            e.getMessage();
            log.error("[{}] Error al actualizar el estado de la persona: {}, message: {} ", Thread.currentThread().getId(), personaDto);

        }
        return personaDto;
    }

}
