package com.example.demo.models.views;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.example.demo.models.enitities.TipoDNI;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoDTO {

    private Long idCandidato;

    private String nombre;

    private String apellido;

    private TipoDNI tipoDNI;

    private String dni;

    private Date fechaNacimiento;

}
