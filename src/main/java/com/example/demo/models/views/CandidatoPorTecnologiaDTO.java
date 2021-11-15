package com.example.demo.models.views;

import com.example.demo.models.enitities.Candidato;
import com.example.demo.models.enitities.Tecnologia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CandidatoPorTecnologiaDTO {

    private Long idCandidatoXTecnologia;

    private Candidato candidato;

    private Tecnologia tecnologia;

    private int aniosExperiencia;

}
