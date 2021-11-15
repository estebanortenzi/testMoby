package com.example.demo.controller;

import lombok.extern.java.Log;
import com.example.demo.models.views.TecnologiaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TecnologiaDTO> guardarTecnologia(@RequestBody TecnologiaDTO tecnologiaDTO){
        return new ResponseEntity<TecnologiaDTO> (tecnologiaService.guardarTecnologia(tecnologiaDTO), HttpStatus.CREATED);
    }

    @PostMapping(value = "/modificarTecnologia")
    public ResponseEntity<TecnologiaDTO> modificarTecnologia(@RequestBody TecnologiaDTO tecnologiaDTO){
        return new ResponseEntity<TecnologiaDTO> (tecnologiaService.modificarTecnologia(tecnologiaDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/obtenerTecnologias")
    public ResponseEntity<List<TecnologiaDTO>> obtenerTecnologias(){
        return new ResponseEntity<List<TecnologiaDTO>>(tecnologiaService.obtenerTecnologias(), HttpStatus.OK);
    }

    @GetMapping(path = "/buscarTecnologiaPorId/{idTecnologia}")
    public ResponseEntity<TecnologiaDTO> buscarTecnologiaPorId(@PathVariable Long idTecnologia){
        return new ResponseEntity<TecnologiaDTO> (tecnologiaService.buscarTecnologiaPorId(idTecnologia), HttpStatus.OK);
    }

    @GetMapping(path = "/buscarTecnologiaPorNombre/{nombreTecnologia}")
    public ResponseEntity<TecnologiaDTO> buscarTecnologiaPorNombre(@PathVariable String nombreTecnologia){
        return new ResponseEntity<TecnologiaDTO> (tecnologiaService.buscarTecnologiaPorNombre(nombreTecnologia), HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminarTecnologiaPorId/{idTecnologia}")
    public ResponseEntity eliminarTecnologiaPorId(@PathVariable Long idTecnologia){
        tecnologiaService.eliminarTecnologiaPorId(idTecnologia);
        return new ResponseEntity (HttpStatus.OK);
    }

}
