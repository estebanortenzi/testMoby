package com.example.demo.servicies;

import com.example.demo.models.enitities.Candidato;
import com.example.demo.models.views.CandidatoDTO;

import java.util.List;


public interface CandidatoService {

    CandidatoDTO guardarCandidato(CandidatoDTO candidatoDTO);

    CandidatoDTO modificarCandidato(CandidatoDTO candidatoDTO);

    List<CandidatoDTO> obtenerCandidatos();

    void eliminarCandidatoPorId(Long idCandidatoDTO);

    CandidatoDTO buscarCandidatoPorId(Long idCandidato);

    CandidatoDTO buscarCandidatoPorDni(String dni);

}
