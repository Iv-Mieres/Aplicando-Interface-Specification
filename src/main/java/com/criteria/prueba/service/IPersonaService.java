package com.criteria.prueba.service;

import com.criteria.prueba.dto.FiltroPersonaDTO;
import com.criteria.prueba.model.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonaService {

    public Persona savePersona(Persona persona);
    public Page<Persona> findAllPersonas(FiltroPersonaDTO filtro, Pageable pageable);
    public void deletePersona(Long idPersona);


}
