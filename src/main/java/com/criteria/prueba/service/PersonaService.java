package com.criteria.prueba.service;

import com.criteria.prueba.dto.FiltroPersonaDTO;
import com.criteria.prueba.model.Persona;
import com.criteria.prueba.repository.IPersonaRepository;
import com.criteria.prueba.specification.FiltroSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private IPersonaRepository personaRepository;

    @Autowired
    private FiltroSpecification personaSpecification;

    //GUARDA UNA PERSONA
    @Override
    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    //MUESTRA UNA LISTA DE PERSONAS PAGINADAS UTILIZANDO FILTROS DE BUSQUEDA
    @Override
    public Page<Persona> findAllPersonas(FiltroPersonaDTO filtro, Pageable pageable){
        return personaRepository.findAll(personaSpecification.filtrarDatos(filtro), pageable);
    }

    //ELIMINA UNA PERSONA POR ID
    @Override
    public void deletePersona(Long idPersona) {
        personaRepository.deleteById(idPersona);
    }
}
