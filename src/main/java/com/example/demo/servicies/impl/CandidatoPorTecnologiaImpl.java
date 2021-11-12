package com.example.demo.servicies.impl;

import com.example.demo.models.enitities.CandidatoPorTecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.CandidatoPorTecnologiaRepository;
import com.example.demo.servicies.CandidatoPorTecnologiaService;

import java.util.List;

@Service
public class CandidatoPorTecnologiaImpl implements CandidatoPorTecnologiaService {

    @Autowired
    CandidatoPorTecnologiaRepository candidatoPorTecnologiaRepository;

    public CandidatoPorTecnologia guardarCandidatoPorTecnologia(CandidatoPorTecnologia candidatoPorTecnologia){
        return candidatoPorTecnologiaRepository.save(candidatoPorTecnologia);
    }

    public List<CandidatoPorTecnologia> obtenerCandidatosPorTecnologia(){
        return candidatoPorTecnologiaRepository.findAll();
    }

    public void eliminarCandidatoPorTecnologia(CandidatoPorTecnologia candidatoPorTecnologia){
        candidatoPorTecnologiaRepository.delete(candidatoPorTecnologia);
    }

    public CandidatoPorTecnologia buscarCandidatoPorTecnologiaPorId(CandidatoPorTecnologia candidatoPorTecnologia){
        return candidatoPorTecnologiaRepository.findById(candidatoPorTecnologia.getIdCandidatoXTecnologia()).orElseThrow();
    }

    public CandidatoPorTecnologia modificarCandidatoPorTecnologia(CandidatoPorTecnologia candidatoPorTecnologia){
        CandidatoPorTecnologia candidatoPorTecnologiaBuscado = candidatoPorTecnologiaRepository.findById(candidatoPorTecnologia.getIdCandidatoXTecnologia()).orElseThrow();

        candidatoPorTecnologiaBuscado.setCandidato(candidatoPorTecnologia.getCandidato());
        candidatoPorTecnologiaBuscado.setTecnologia(candidatoPorTecnologia.getTecnologia());
        candidatoPorTecnologiaBuscado.setAniosExperiencia(candidatoPorTecnologia.getAniosExperiencia());

        return candidatoPorTecnologiaRepository.save(candidatoPorTecnologiaBuscado);
    }

}
