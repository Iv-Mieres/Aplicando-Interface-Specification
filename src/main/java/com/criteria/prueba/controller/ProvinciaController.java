package com.criteria.prueba.controller;

import com.criteria.prueba.dto.FiltroProvinciaDTO;
import com.criteria.prueba.model.Provincia;
import com.criteria.prueba.service.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProvinciaController {

    @Autowired
    private IProvinciaService provinciaService;

    @PostMapping("/provincias/crear")
    public ResponseEntity<Provincia> saveProvincia(@RequestBody Provincia provincia){
        return ResponseEntity.status(HttpStatus.CREATED).body(provinciaService.saveProvincia(provincia));
    }

    @DeleteMapping("/provincias/eliminar/{idProvincia}")
    public ResponseEntity<String> deleteProvincia(@PathVariable Long idProvincia){
        provinciaService.deleteProvincia(idProvincia);
        return ResponseEntity.status(HttpStatus.OK).body("La provincia se eliminó correctamente");
    }
    @GetMapping("/provincias/ver_todas")
    public ResponseEntity<Page<Provincia>> listaProvincias(@RequestBody FiltroProvinciaDTO filtro, Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(provinciaService.findAllProvincias(filtro, pageable));
    }

}
