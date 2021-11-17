package com.example.demo.models.views;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidatoPorTecnologiaDTO {

    private Long idCandidatoXTecnologia;

    private CandidatoDTO candidatoDTO;

    private TecnologiaDTO tecnologiaDTO;

    private int aniosExperiencia;

}
