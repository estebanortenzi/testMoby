package com.example.demo.servicies.impl;

import com.example.demo.exceptions.TecnologiaNoEncontrada;
import com.example.demo.models.enitities.Tecnologia;
import com.example.demo.models.views.TecnologiaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.TecnologiaRepository;
import com.example.demo.servicies.TecnologiaService;

import java.util.List;

@Service
public class TecnologiaServiceImpl implements TecnologiaService {

    @Autowired
    TecnologiaRepository tecnologiaRepository;

    // el .save sabe distinguir si es una tecnologia nueva. Si lo es, le agrega ID, sino la modifica
    public void guardarTecnologia(TecnologiaDTO tecnologiaDTO){
        Tecnologia tecnologia = Tecnologia.builder()
                .version(tecnologiaDTO.getVersion())
                .build();

         tecnologiaRepository.save(tecnologia);
    }

    public List<Tecnologia> obtenerTecnologias(){

        return tecnologiaRepository.findAll();
    }

    public void eliminarTecnologiaPorId(Long idTecnologia){

        tecnologiaRepository.deleteById(idTecnologia);
    }

    public Tecnologia buscarTecnologiaPorId(Long idTecnologia){
        return tecnologiaRepository.findById(idTecnologia)
                .orElseThrow(()-> new TecnologiaNoEncontrada("No se encontro la tecnologia"));
    }

}
