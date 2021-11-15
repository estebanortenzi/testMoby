package com.example.demo.servicies.impl;

import com.example.demo.exceptions.IdEncontradoException;
import com.example.demo.exceptions.IdNoEncontradoException;
import com.example.demo.models.enitities.Tecnologia;
import com.example.demo.models.views.TecnologiaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.TecnologiaRepository;
import com.example.demo.servicies.TecnologiaService;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class TecnologiaServiceImpl implements TecnologiaService {

    @Autowired
    TecnologiaRepository tecnologiaRepository;


    public void guardarTecnologia(TecnologiaDTO tecnologiaDTO){
        if(tecnologiaDTO.getIdTecnologia() != null){
            throw new IdEncontradoException("La tecnologia tiene ID. Utilice modificarTecnologia");
        }
        Tecnologia tecnologia = Tecnologia.builder()
                .nombre(tecnologiaDTO.getNombre())
                .version(tecnologiaDTO.getVersion())
                .build();

         tecnologiaRepository.save(tecnologia);
    }

    public void modificarTecnologia(TecnologiaDTO tecnologiaDTO){
        if(tecnologiaDTO.getIdTecnologia() == null){
            throw new IdNoEncontradoException("No se puede modificar una tecnologa sin ID.");
        }
        Tecnologia tecnologia = Tecnologia.builder()
                .nombre(tecnologiaDTO.getNombre())
                .version(tecnologiaDTO.getVersion())
                .build();

        tecnologiaRepository.save(tecnologia);
    }

    public List<Tecnologia> obtenerTecnologias(){

        return tecnologiaRepository.findAll();
    }

    public void eliminarTecnologiaPorId(Long idTecnologia){
        if(tecnologiaRepository.findById(idTecnologia).orElseThrow() == null){
            throw new IdEncontradoException("No se encontró una tecnologia con ese ID.");
        }else{
            tecnologiaRepository.deleteById(idTecnologia);
        }
    }

    public Tecnologia buscarTecnologiaPorId(Long idTecnologia){
        return tecnologiaRepository.findById(idTecnologia)
                .orElseThrow(()-> new EntityExistsException("No se encontró el candidato"));
    }

}
