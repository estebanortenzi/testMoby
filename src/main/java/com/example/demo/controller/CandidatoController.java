package com.example.demo.controller;


import lombok.extern.java.Log;
import com.example.demo.models.enitities.Candidato;
import com.example.demo.models.views.CandidatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void guardarCandidato(@RequestBody CandidatoDTO candidatoDTO){
        candidatoService.guardarCandidato(candidatoDTO);
    }

    @PostMapping(value = "/modificarCandidato")
    public void modificarCandidato(@RequestBody CandidatoDTO candidatoDTO){
        candidatoService.modificarCandidato(candidatoDTO);
    }

    @GetMapping(value = "/obtenerCandidatos")
    public List<Candidato> obtenerCandidatos(){
        return candidatoService.obtenerCandidatos();
    }

    @GetMapping(path = "buscarCandidato/{idCandidato}")
    public Candidato buscarCandidatoPorId(@PathVariable("idCandidato") Long idCandidato){
        return candidatoService.buscarCandidatoPorId(idCandidato);
    }

    @GetMapping(path = "buscarCandidato/{dniCandidato}")
    public Candidato buscarCandidatoPorDni(@PathVariable("dniCandidato") String dniCandidato){
        return candidatoService.buscarCandidatoPorDni(dniCandidato);
    }

    @DeleteMapping(value = "/eliminarCandidatoPorId/{idCandidato}")
    public void eliminarCandidatoPorId(@PathVariable("idCandidato") Long idCandidato){
        candidatoService.eliminarCandidatoPorId(idCandidato);
    }

}
