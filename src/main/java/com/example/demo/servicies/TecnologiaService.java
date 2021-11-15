package com.example.demo.servicies;

import com.example.demo.models.enitities.Tecnologia;
import com.example.demo.models.views.TecnologiaDTO;

import java.util.List;

public interface TecnologiaService {

    void guardarTecnologia(TecnologiaDTO tecnologiaDTO);

    void modificarTecnologia(TecnologiaDTO tecnologiaDTO);

    List<Tecnologia> obtenerTecnologias();

    void eliminarTecnologiaPorId(Long idTecnologia);

    Tecnologia buscarTecnologiaPorId(Long idTecnologia);

}
