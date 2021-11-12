package com.example.demo.servicies;

import com.example.demo.models.enitities.CandidatoPorTecnologia;

import java.util.List;

public interface CandidatoPorTecnologiaService {

    CandidatoPorTecnologia guardarCandidatoPorTecnologia(CandidatoPorTecnologia candidatoPorTecnologia);

    List<CandidatoPorTecnologia> obtenerCandidatosPorTecnologia();

    void eliminarCandidatoPorTecnologia(CandidatoPorTecnologia candidatoPorTecnologia);

    CandidatoPorTecnologia buscarCandidatoPorTecnologiaPorId(CandidatoPorTecnologia candidatoPorTecnologia);

    CandidatoPorTecnologia modificarCandidatoPorTecnologia(CandidatoPorTecnologia candidatoPorTecnologia);



}
