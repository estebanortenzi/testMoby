package com.example.demo.servicies.impl;

import com.example.demo.exceptions.IdEncontradoException;
import com.example.demo.exceptions.TecnologiaInexistente;
import com.example.demo.models.enitities.Tecnologia;
import com.example.demo.models.views.TecnologiaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.TecnologiaRepository;
import com.example.demo.servicies.TecnologiaService;

import javax.persistence.EntityExistsException;
import java.util.LinkedList;
import java.util.List;

@Service
public class TecnologiaServiceImpl implements TecnologiaService {

    @Autowired
    TecnologiaRepository tecnologiaRepository;

    @Autowired
    ModelMapper modelMapper;

    public TecnologiaDTO guardarTecnologia(TecnologiaDTO tecnologiaDTO){

        Tecnologia nuevo = modelMapper.map(tecnologiaDTO, Tecnologia.class);

        Tecnologia tecnologia = tecnologiaRepository.save(nuevo);

        TecnologiaDTO tecnologiaDTO1 = modelMapper.map(tecnologia, TecnologiaDTO.class);

        return  tecnologiaDTO1;
    }

    public TecnologiaDTO modificarTecnologia(TecnologiaDTO tecnologiaDTO){

        Tecnologia nuevo = modelMapper.map(tecnologiaDTO, Tecnologia.class);

        Tecnologia tecnologia = tecnologiaRepository.save(nuevo);

        TecnologiaDTO tecnologiaDTO1 = modelMapper.map(tecnologia, TecnologiaDTO.class);

        return  tecnologiaDTO1;
    }

    public List<TecnologiaDTO> obtenerTecnologias(){

        List<Tecnologia> tecnologias = tecnologiaRepository.findAll();
        List<TecnologiaDTO> tecnologiasDTOS = new LinkedList<>();

        for (Tecnologia tecnologia: tecnologias) {
            tecnologiasDTOS.add(modelMapper.map(tecnologia, TecnologiaDTO.class));
        }

        return tecnologiasDTOS;
    }

    public void eliminarTecnologiaPorId(Long idTecnologia){
        if(tecnologiaRepository.findById(idTecnologia).orElseThrow() == null){
            throw new IdEncontradoException("No se encontró una tecnologia con ese ID.");
        }else{
            tecnologiaRepository.deleteById(idTecnologia);
        }
    }

    public TecnologiaDTO buscarTecnologiaPorId(Long idTecnologia){

        Tecnologia tecnologia = tecnologiaRepository.findById(idTecnologia)
                .orElseThrow(()-> new EntityExistsException("No se encontró el candidato"));

        TecnologiaDTO tecnologiaDTO = modelMapper.map(tecnologia, TecnologiaDTO.class);

        return tecnologiaDTO;
    }

    public TecnologiaDTO buscarTecnologiaPorNombre(String nombre){

        Tecnologia tecnologia = tecnologiaRepository.findByNombre(nombre);

        if(tecnologia == null){
            throw new TecnologiaInexistente("No existe una tecnología con ese nombre");
        }

        TecnologiaDTO tecnologiaDTO = modelMapper.map(tecnologia, TecnologiaDTO.class);

        return tecnologiaDTO;
    }

}

