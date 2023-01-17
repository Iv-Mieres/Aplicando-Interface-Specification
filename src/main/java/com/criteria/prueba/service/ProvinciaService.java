package com.criteria.prueba.service;

import com.criteria.prueba.dto.FiltroProvinciaDTO;
import com.criteria.prueba.model.Provincia;
import com.criteria.prueba.repository.IProvinciaRepository;
import com.criteria.prueba.specification.FiltroSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaService implements IProvinciaService{
    @Autowired
    private IProvinciaRepository provinciaRepository;

    @Autowired
    private FiltroSpecification specification;

    //GUARDAR UNA PROVINCIA
    @Override
    public Provincia saveProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    //MUESTRA UNA LISTA DE PROVINCIAS PAGINADAS UTILIZANDO FILTROS DE BUSQUEDA
    @Override
    public Page<Provincia> findAllProvincias(FiltroProvinciaDTO filtro, Pageable pageable) {
        return provinciaRepository.findAll(specification.filtrarProvincia(filtro), pageable);
    }

    //ELIMINA UNA PROVINCIA POR ID
    @Override
    public void deleteProvincia(Long idProvincia) {
        provinciaRepository.deleteById(idProvincia);
    }
}
