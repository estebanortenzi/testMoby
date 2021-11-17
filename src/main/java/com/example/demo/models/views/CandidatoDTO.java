package com.example.demo.models.views;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import com.example.demo.models.enitities.TipoDocumento;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidatoDTO {

    private Long idCandidato;

    private String nombre;

    private String apellido;

    private TipoDocumento tipoDocumento;

    private String dni;

    private Date fechaNacimiento;
}
