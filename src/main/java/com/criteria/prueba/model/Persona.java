package com.criteria.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String dni;


    @OneToOne
    @JoinColumn(name = "idProvincia", referencedColumnName = "idProvincia")
    private Provincia unaProvincia;

}
