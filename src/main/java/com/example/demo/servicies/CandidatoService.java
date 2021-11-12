package com.example.demo.servicies;

import com.example.demo.models.enitities.Candidato;
import com.example.demo.models.views.CandidatoDTO;

import java.util.List;


public interface CandidatoService {

    void guardarCandidato(CandidatoDTO candidatoDTO);

    List<Candidato> obtenerCandidatos();

    void eliminarCandidatoPorId(Long idCandidatoDTO);

    Candidato buscarCandidatoPorId(Long idCandidato);

   // List<Candidato> findByTecnologia(String tecnologia);

}
