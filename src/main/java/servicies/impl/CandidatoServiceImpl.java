package servicies.impl;

import models.Candidato;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.CandidatoRepository;
import servicies.CandidatoServicie;

import java.util.List;

public class CandidatoServiceImpl implements CandidatoServicie {

    @Autowired
    CandidatoRepository candidatoRepository;

    public Candidato guardarCandidato(Candidato candidato){
        return candidatoRepository.save(candidato);
    }

    public List<Candidato> obtenerCandidatos(){
        return candidatoRepository.findAll();
    }

    public void eliminarCandidato(Candidato candidato){
        candidatoRepository.delete(candidato);
    }

    public Candidato buscarCandidatoPorId(Candidato candidato){
        return candidatoRepository.findById(candidato.getIdCandidato()).orElseThrow();
    }

    public Candidato modificarCandidato(Candidato candidato){
        Candidato candidatoBuscado = candidatoRepository.findById(candidato.getIdCandidato()).orElseThrow();

        candidatoBuscado.setNombre(candidato.getNombre());
        candidatoBuscado.setApellido(candidato.getApellido());
        candidatoBuscado.setTipoDNI(candidato.getTipoDNI());
        candidatoBuscado.setDni(candidato.getDni());
        candidatoBuscado.setFechaNacimiento(candidato.getFechaNacimiento());

        return candidatoRepository.save(candidatoBuscado);
    }

}
