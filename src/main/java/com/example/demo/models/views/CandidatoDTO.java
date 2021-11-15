package com.example.demo.models.views;

import lombok.*;

import com.example.demo.models.enitities.TipoDocumento;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CandidatoDTO {

    private Long idCandidato;

    private String nombre;

    private String apellido;

    private TipoDocumento tipoDocumento;

    private String dni;

    private Date fechaNacimiento;

}
