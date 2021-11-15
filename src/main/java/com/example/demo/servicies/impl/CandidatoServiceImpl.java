package com.example.demo.servicies.impl;

import com.example.demo.exceptions.DniExistenteExcpetion;
import com.example.demo.exceptions.DniInexistenteExcpetion;
import com.example.demo.exceptions.IdEncontradoException;
import com.example.demo.models.enitities.Candidato;
import com.example.demo.models.views.CandidatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.CandidatoRepository;
import com.example.demo.servicies.CandidatoService;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    @Autowired
    CandidatoRepository candidatoRepository;

    public void guardarCandidato(CandidatoDTO candidatoDTO){

        if(candidatoRepository.findByDni(candidatoDTO.getDni()) != null){
            throw new DniExistenteExcpetion("Ya existe un candidato con el DNI ingresado.");
        }

        Candidato candidato = Candidato.builder()
                .nombre(candidatoDTO.getNombre())
                .apellido(candidatoDTO.getApellido())
                .dni(candidatoDTO.getDni())
                .fechaNacimiento(candidatoDTO.getFechaNacimiento())
                .tipoDNI(candidatoDTO.getTipoDNI())
                .build();

         candidatoRepository.save(candidato);
    }

    public void modificarCandidato(CandidatoDTO candidatoDTO){
        if(candidatoRepository.findByDni(candidatoDTO.getDni()) == null){
            throw new DniInexistenteExcpetion("No existe un candidato con el DNI ingresado.");
        }

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

        if(candidatoRepository.findById(idCandidatoDTO).orElseThrow() == null){
            throw new IdEncontradoException("No se encontró un candidato con ese ID.");
        }else{
            candidatoRepository.deleteById(idCandidatoDTO);
        }
    }

    public Candidato buscarCandidatoPorId(Long idCandidato){
        return candidatoRepository.findById(idCandidato)
                .orElseThrow(() -> new EntityExistsException("No se encontró el candidato")); //Supplier, no recibe parametros porque es un proveedor
    }

    public Candidato buscarCandidatoPorDni(String dni){
        return candidatoRepository.findByDni(dni);
    }

}
