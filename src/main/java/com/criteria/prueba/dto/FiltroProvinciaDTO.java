package com.criteria.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltroProvinciaDTO {

    private String domicilio;
    private Integer numeroCalle;
    private Integer codigoPostal;
}
