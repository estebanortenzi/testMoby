package com.example.demo.servicies.impl;

import com.example.demo.exceptions.IdNoEncontradoException;
import com.example.demo.models.enitities.CandidatoPorTecnologia;
import com.example.demo.models.views.CandidatoPorTecnologiaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.CandidatoPorTecnologiaRepository;
import com.example.demo.servicies.CandidatoPorTecnologiaService;

import java.util.LinkedList;
import java.util.List;


@Service
public class CandidatoPorTecnologiaImpl implements CandidatoPorTecnologiaService {

    @Autowired
    CandidatoPorTecnologiaRepository candidatoPorTecnologiaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CandidatoPorTecnologiaDTO guardarCandidatoPorTecnologia(CandidatoPorTecnologiaDTO candidatoPorTecnologiaDTO){

        CandidatoPorTecnologia candPorTec = modelMapper.map(candidatoPorTecnologiaDTO, CandidatoPorTecnologia.class);

        CandidatoPorTecnologia candidatoPorTecnologia = candidatoPorTecnologiaRepository.save(candPorTec);

        return modelMapper.map(candidatoPorTecnologia, CandidatoPorTecnologiaDTO.class);
    }

    @Override
    public CandidatoPorTecnologiaDTO modificarCandidatoPorTecnologia(CandidatoPorTecnologiaDTO candidatoPorTecnologiaDTO){

        if(candidatoPorTecnologiaRepository.findById(candidatoPorTecnologiaDTO.getIdCandidatoXTecnologia()).orElseThrow() == null){
            throw new IdNoEncontradoException("No se encontro el ID");
        }

        CandidatoPorTecnologia candPorTec = modelMapper.map(candidatoPorTecnologiaDTO, CandidatoPorTecnologia.class);

        CandidatoPorTecnologia candidatoPorTecnologia = candidatoPorTecnologiaRepository.save(candPorTec);

        return modelMapper.map(candidatoPorTecnologia, CandidatoPorTecnologiaDTO.class);
    }

    @Override
    public List<CandidatoPorTecnologiaDTO> obtenerCandidatosPorTecnologias(){

        List<CandidatoPorTecnologia> listaCandPorTecn = candidatoPorTecnologiaRepository.findAll();
        List<CandidatoPorTecnologiaDTO> listaCandPorTecnDTO = new LinkedList<>();

        for (CandidatoPorTecnologia candPorTec : listaCandPorTecn) {
            listaCandPorTecnDTO.add(modelMapper.map(candPorTec, CandidatoPorTecnologiaDTO.class));
        }

        return listaCandPorTecnDTO;
    }






}
