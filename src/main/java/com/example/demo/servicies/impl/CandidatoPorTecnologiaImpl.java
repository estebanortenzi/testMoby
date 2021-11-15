package com.example.demo.servicies.impl;

import com.example.demo.models.enitities.CandidatoPorTecnologia;
import com.example.demo.models.views.CandidatoPorTecnologiaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.CandidatoPorTecnologiaRepository;
import com.example.demo.servicies.CandidatoPorTecnologiaService;

import javax.persistence.EntityExistsException;
import java.util.LinkedList;
import java.util.List;

@Service
public class CandidatoPorTecnologiaImpl implements CandidatoPorTecnologiaService {

    @Autowired
    CandidatoPorTecnologiaRepository candidatoPorTecnologiaRepository;

    @Autowired
    ModelMapper modelMapper;

    public CandidatoPorTecnologiaDTO guardarCandidatoPorTecnologia(CandidatoPorTecnologiaDTO candidatoPorTecnologiaDTO){

        CandidatoPorTecnologia candidatoPorTecnologia = candidatoPorTecnologiaRepository.save(modelMapper.map(candidatoPorTecnologiaDTO, CandidatoPorTecnologia.class));

        CandidatoPorTecnologiaDTO candidatoPorTecnologiaDTO1 = modelMapper.map(candidatoPorTecnologia, CandidatoPorTecnologiaDTO.class);

        return candidatoPorTecnologiaDTO1;
    }



}
