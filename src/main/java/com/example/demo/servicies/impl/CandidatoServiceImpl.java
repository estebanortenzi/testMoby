package com.example.demo.servicies.impl;

import com.example.demo.exceptions.DniInexistenteExcpetion;
import com.example.demo.exceptions.IdEncontradoException;
import com.example.demo.models.enitities.Candidato;
import com.example.demo.models.views.CandidatoDTO;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.CandidatoRepository;
import com.example.demo.servicies.CandidatoService;

import javax.persistence.EntityExistsException;
import java.util.LinkedList;
import java.util.List;

@Log
@Service
public class CandidatoServiceImpl implements CandidatoService {

    @Autowired
    CandidatoRepository candidatoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CandidatoDTO guardarCandidato(CandidatoDTO candidatoDTO){

        if(candidatoDTO == null){
            log.info("No se puede guardar un candidato vacio");
        }

        Candidato nuevo = modelMapper.map(candidatoDTO, Candidato.class);

            Candidato candidato = candidatoRepository.save(nuevo);

            log.info("Candidato guardado exitosamente.");

            CandidatoDTO canDTO = modelMapper.map(candidato, CandidatoDTO.class);

            return canDTO;
    }

    @Override
    public CandidatoDTO modificarCandidato(CandidatoDTO candidatoDTO){

        if(candidatoDTO == null){
            log.info("Candidato vacio. No se puede modificar");
        }
        Candidato nuevo = modelMapper.map(candidatoDTO, Candidato.class);

        Candidato candidato = candidatoRepository.save(nuevo);

        CandidatoDTO canDTO = modelMapper.map(candidato, CandidatoDTO.class);

        return canDTO;
    }

    @Override
    public List<CandidatoDTO> obtenerCandidatos(){

        List<Candidato> candidatos = candidatoRepository.findAll();
        List<CandidatoDTO> candidatoDTOS = new LinkedList<>();

        for (Candidato candidato: candidatos) {
            candidatoDTOS.add(modelMapper.map(candidato,CandidatoDTO.class));
        }

        return candidatoDTOS;
    }

    @Override
    public void eliminarCandidatoPorId(Long idCandidatoDTO){

        if(candidatoRepository.findById(idCandidatoDTO).orElseThrow() == null){
            throw new IdEncontradoException("No se encontró un candidato con ese ID.");
        }else{
            candidatoRepository.deleteById(idCandidatoDTO);
            log.info("Candidato borrado exitosamente.");
        }
    }

    @Override
    public CandidatoDTO buscarCandidatoPorId(Long idCandidato){

        Candidato candidato = candidatoRepository.findById(idCandidato).orElseThrow(() -> new EntityExistsException("No se encontró el candidato"));//Supplier, no recibe parametros porque es un proveedor

        CandidatoDTO candidatoDTO = modelMapper.map(candidato, CandidatoDTO.class);

        return candidatoDTO;
    }

    @Override
    public CandidatoDTO buscarCandidatoPorDni(String dni){

        Candidato candidato = candidatoRepository.findByDni(dni);
        if(candidato == null){
            throw new DniInexistenteExcpetion("No se encuentra un candidato con ese DNI");
        }
        CandidatoDTO candidatoDTO = modelMapper.map(candidato, CandidatoDTO.class);
        return candidatoDTO;
    }

}
