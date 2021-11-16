package com.example.demo.servicies;

import com.example.demo.models.views.CandidatoPorTecnologiaDTO;

import java.util.List;

public interface CandidatoPorTecnologiaService {

    CandidatoPorTecnologiaDTO guardarCandidatoPorTecnologia(CandidatoPorTecnologiaDTO candidatoPorTecnologiaDTO);

    CandidatoPorTecnologiaDTO modificarCandidatoPorTecnologia(CandidatoPorTecnologiaDTO candidatoPorTecnologiaDTO);

    List<CandidatoPorTecnologiaDTO> obtenerCandidatosPorTecnologias();

}
