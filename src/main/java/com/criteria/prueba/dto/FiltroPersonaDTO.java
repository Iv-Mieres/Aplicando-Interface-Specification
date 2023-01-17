package com.criteria.prueba.dto;

import com.criteria.prueba.model.Provincia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltroPersonaDTO {

    private String nombre;
    private String apellido;
    private String dni;
    private String nombreProvincia;
    private String localidad;

}
