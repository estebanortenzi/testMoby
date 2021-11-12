package com.example.demo.controller;

import lombok.extern.java.Log;
import com.example.demo.models.enitities.Tecnologia;
import com.example.demo.models.views.TecnologiaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.example.demo.servicies.TecnologiaService;

import java.util.List;

@Log
@RestController
@RequestMapping(value = "/api/tecnologia")
public class TecnologiaController {

    @Autowired
    TecnologiaService tecnologiaService;

    @PostMapping(value = "/guardarTecnologia")
    public void guardarTecnologia(@RequestBody TecnologiaDTO tecnologiaDTO){
        tecnologiaService.guardarTecnologia(tecnologiaDTO);
    }

    @GetMapping(value = "/obtenerTecnologias")
    public List<Tecnologia> obtenerTecnologias(){
        return tecnologiaService.obtenerTecnologias();
    }

    @GetMapping(path = "/{idTecnologia}")
    public Tecnologia buscarTecnologiaPorId(@PathVariable("idTecnologia") Long idTecnologia){
        return tecnologiaService.buscarTecnologiaPorId(idTecnologia);
    }

    @DeleteMapping(value = "/eliminarTecnologiaPorId/{idTecnologia}")
    public void eliminarTecnologiaPorId(@PathVariable("idTecnologia") Long idTecnologia){
        tecnologiaService.eliminarTecnologiaPorId(idTecnologia);
    }

}
