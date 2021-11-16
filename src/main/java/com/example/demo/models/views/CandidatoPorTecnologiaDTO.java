package com.example.demo.models.views;

import com.example.demo.models.enitities.Candidato;
import com.example.demo.models.enitities.Tecnologia;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CandidatoPorTecnologiaDTO {

    private Long idCandidatoXTecnologia;

    private CandidatoDTO candidatoDTO;

    private TecnologiaDTO tecnologiaDTO;

    private int aniosExperiencia;

}
