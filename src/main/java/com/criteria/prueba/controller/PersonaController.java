package com.criteria.prueba.controller;

import com.criteria.prueba.dto.FiltroPersonaDTO;
import com.criteria.prueba.model.Persona;
import com.criteria.prueba.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @PostMapping("/personas/crear")
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.savePersona(persona));
    }

    @DeleteMapping("/personas/eliminar/{idPersona}")
    public ResponseEntity<String> deletePersona(@PathVariable Long idPersona){
        personaService.deletePersona(idPersona);
        return ResponseEntity.status(HttpStatus.OK).body("La persona se elimnó correctamente");
    }

    @GetMapping("/personas/ver_todas")
    public ResponseEntity<Page<Persona>> listaPersonas(@RequestBody FiltroPersonaDTO filtro, Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(personaService.findAllPersonas(filtro, pageable));
    }

}
