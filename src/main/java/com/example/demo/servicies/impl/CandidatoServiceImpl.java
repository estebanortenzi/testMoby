package com.example.demo.servicies.impl;

import com.example.demo.exceptions.CandidatoNoEncontrado;
import com.example.demo.models.enitities.Candidato;
import com.example.demo.models.views.CandidatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.CandidatoRepository;
import com.example.demo.servicies.CandidatoService;

import java.util.List;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    @Autowired
    CandidatoRepository candidatoRepository;

    // el .save sabe distinguir si es un candidato nuevo. Si lo es, le agrega ID, sino la modifica
    public void guardarCandidato(CandidatoDTO candidatoDTO){

        Candidato candidato = Candidato.builder()
                .nombre(candidatoDTO.getNombre())
                .apellido(candidatoDTO.getApellido())
                .dni(candidatoDTO.getDni())
                .fechaNacimiento(candidatoDTO.getFechaNacimiento())
                .tipoDNI(candidatoDTO.getTipoDNI())
                .build();

         candidatoRepository.save(candidato);
    }

    public List<Candidato> obtenerCandidatos(){
        return candidatoRepository.findAll();
    }

    public void eliminarCandidatoPorId(Long idCandidatoDTO){
            candidatoRepository.deleteById(idCandidatoDTO);
    }

    public Candidato buscarCandidatoPorId(Long idCandidato){
        return candidatoRepository.findById(idCandidato)
                .orElseThrow(() -> new CandidatoNoEncontrado("No se encontró el candidato")); //Supplier, no recibe parametros porque es un proveedor
    }

    /*
    public List<Candidato> findByTecnologia(String tecnologia) {
        List<Candidato> candidatos = candidatoRepository.findByTecnologia(tecnologia);

        for (Candidato cand: candidatos){

        }

        return null;
    }
*/

}
