package servicies.impl;

import models.CandidatoPorTecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.CandidatoPorTecnologiaRepository;

import java.util.List;

public class CandidatoPorTecnologiaImpl {

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
