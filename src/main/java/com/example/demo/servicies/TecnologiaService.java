package com.example.demo.servicies;

import com.example.demo.models.enitities.Tecnologia;
import com.example.demo.models.views.TecnologiaDTO;

import java.util.List;

public interface TecnologiaService {

    TecnologiaDTO guardarTecnologia(TecnologiaDTO tecnologiaDTO);

    TecnologiaDTO modificarTecnologia(TecnologiaDTO tecnologiaDTO);

    List<TecnologiaDTO> obtenerTecnologias();

    void eliminarTecnologiaPorId(Long idTecnologia);

}
