package com.criteria.prueba.service;

import com.criteria.prueba.dto.FiltroProvinciaDTO;
import com.criteria.prueba.model.Provincia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProvinciaService {

    public Provincia saveProvincia(Provincia provincia);
    public Page<Provincia> findAllProvincias(FiltroProvinciaDTO filtro, Pageable pageable);
    public void deleteProvincia(Long idprovincia);
    

}
