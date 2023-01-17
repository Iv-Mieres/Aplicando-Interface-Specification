package com.criteria.prueba.specification;

import com.criteria.prueba.dto.FiltroPersonaDTO;
import com.criteria.prueba.dto.FiltroProvinciaDTO;
import com.criteria.prueba.model.Persona;
import com.criteria.prueba.model.Persona_;

import com.criteria.prueba.model.Provincia;
import com.criteria.prueba.model.Provincia_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Component
public class FiltroSpecification {

    //FILTRA LA BUSQUEDA DE PERSONAS
    public Specification<Persona> filtrarDatos(FiltroPersonaDTO filtro) {

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filtro.getNombre() != null) {
                predicates.add(criteriaBuilder.equal(root.get(Persona_.NOMBRE), filtro.getNombre()));
            }
            if (filtro.getApellido() != null) {
                predicates.add(criteriaBuilder.equal(root.get(Persona_.APELLIDO), filtro.getApellido()));
            }
            if (filtro.getDni() != null) {
                predicates.add(criteriaBuilder.equal(root.get(Persona_.DNI), filtro.getDni()));
            }
            if(filtro.getNombreProvincia() != null){
                predicates.add(criteriaBuilder.equal(root.join(Persona_.unaProvincia).get(Provincia_.NOMBRE_PROVINCIA), filtro.getNombreProvincia()));
            }
            if(filtro.getLocalidad() != null){
                predicates.add(criteriaBuilder.equal(root.join(Persona_.unaProvincia).get(Provincia_.LOCALIDAD), filtro.getLocalidad()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    //FILTRA LA BUSQUEDA DE PROVINCIAS
    public Specification<Provincia> filtrarProvincia(FiltroProvinciaDTO filtro) {
        return (root, query, criteriaBuilder) -> {
            var predicates = new ArrayList<Predicate>();

            if (filtro.getDomicilio() != null) {
                predicates.add(criteriaBuilder.equal(root.get(Provincia_.DOMICILIO), filtro.getDomicilio()));
            }
            if (filtro.getNumeroCalle() != null) {
                predicates.add(criteriaBuilder.equal(root.get(Provincia_.NUMERO_CALLE), filtro.getNumeroCalle()));
            }
            if (filtro.getCodigoPostal() != null) {
                predicates.add(criteriaBuilder.equal(root.get(Provincia_.CODIGO_POSTAL), filtro.getCodigoPostal()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

