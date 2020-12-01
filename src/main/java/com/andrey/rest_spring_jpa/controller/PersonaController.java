package com.andrey.rest_spring_jpa.controller;

import com.andrey.rest_spring_jpa.domain.GenericDto;
import com.andrey.rest_spring_jpa.dto.PersonaDto;
import com.andrey.rest_spring_jpa.service.IPersonaService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("persona")
public class PersonaController {

    private final IPersonaService iPersonaService;

    @Autowired
    public PersonaController(IPersonaService iPersonaService) {
        this.iPersonaService = iPersonaService;
    }

    @ApiOperation(value = "Listado de personas", response = GenericDto.class)
    @GetMapping("obtenerPersonas")
    public ResponseEntity<GenericDto> obtenerPersonas() {
        log.info("[{}]- consultando listado de personas, message{}..", Thread.currentThread().getId());
        return ResponseEntity.ok().body(GenericDto.sucess(iPersonaService.obtenerPersonas()));
    }
    
    @ApiOperation(value = "Creación de una persona", response = GenericDto.class)
    @PostMapping("crearPersona")
    public ResponseEntity<GenericDto> crearPersona(@RequestBody PersonaDto personaDto) {
        log.info("[{}]- Crear Persona, message{}..", Thread.currentThread().getId());
        return ResponseEntity.ok().body(GenericDto.sucess(iPersonaService.crearPersona(personaDto)));
    }
    
    @ApiOperation(value = "Actualización de una persona", response = GenericDto.class)
    @PostMapping("actualizarPersona")
    public ResponseEntity<GenericDto> actualizarPersona(@RequestBody PersonaDto personaDto) {
        log.info("[{}]- Actualizar Persona, message{}..", Thread.currentThread().getId());
        return ResponseEntity.ok().body(GenericDto.sucess(iPersonaService.actualizarPersona(personaDto)));
    }
    
    @ApiOperation(value = "Actualización del estado de la persona", response = GenericDto.class)
    @PostMapping("actualizarEstadoPersona")
    public ResponseEntity<GenericDto> actualizarEstadoPersona(@RequestBody PersonaDto personaDto) {
        log.info("[{}]- Actualizar estado de la persona, message{}..", Thread.currentThread().getId());
        return ResponseEntity.ok().body(GenericDto.sucess(iPersonaService.actualizarEstadoPersona(personaDto.getId())));
    }

}
