package com.example.demo.controller;


import com.example.demo.models.views.CandidatoPorTecnologiaDTO;
import lombok.extern.java.Log;
import com.example.demo.models.views.CandidatoDTO;
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

import com.example.demo.servicies.CandidatoService;

import java.util.List;

@Log
@RestController
@RequestMapping(value = "/api/candidato")
public class CandidatoController {

    @Autowired
    CandidatoService candidatoService;


    @PostMapping(value = "/guardarCandidato")
    public ResponseEntity<CandidatoDTO> guardarCandidato(@RequestBody CandidatoDTO candidatoDTO){

        return new ResponseEntity<> (candidatoService.guardarCandidato(candidatoDTO), HttpStatus.CREATED);
    }

    @PostMapping(value = "/modificarCandidato")
    public ResponseEntity<CandidatoDTO> modificarCandidato(@RequestBody CandidatoDTO candidatoDTO){
        return new ResponseEntity<> (candidatoService.modificarCandidato(candidatoDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/obtenerCandidatos")
    public ResponseEntity<List<CandidatoDTO>> obtenerCandidatos(){
        return new ResponseEntity <> (candidatoService.obtenerCandidatos(), HttpStatus.OK);
    }

    @GetMapping(path = "/buscarCandidatoPorId/{idCandidato}")
    public ResponseEntity<CandidatoDTO> buscarCandidatoPorId(@PathVariable Long idCandidato){
        return new ResponseEntity<> (candidatoService.buscarCandidatoPorId(idCandidato), HttpStatus.OK);
    }

    @GetMapping(path = "/buscarCandidatoPorDni/{dniCandidato}")
    public ResponseEntity<CandidatoDTO> buscarCandidatoPorDni(@PathVariable String dniCandidato){
        return new ResponseEntity<> (candidatoService.buscarCandidatoPorDni(dniCandidato), HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminarCandidatoPorId/{idCandidato}")
    public ResponseEntity eliminarCandidatoPorId(@PathVariable Long idCandidato){
        candidatoService.eliminarCandidatoPorId(idCandidato);
        return new ResponseEntity (HttpStatus.OK);
    }

    @GetMapping(value = "/listarCandidatosPorTecnologia/{nombreTecnologia}")
    public ResponseEntity<List<CandidatoPorTecnologiaDTO>> listarCandidatosPorTecnologia(@PathVariable String nombreTecnologia){
        return new ResponseEntity<>(candidatoService.listarCandidatoPorTecnologia(nombreTecnologia), HttpStatus.OK);

    }

}
