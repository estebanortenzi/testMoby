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

    @PostMapping(value = "/guardarCandidato") //si en Postman le pongo el email, modifica, sino lo crea
    public void guardarCandidato(@RequestBody CandidatoDTO candidatoDTO){
        candidatoService.guardarCandidato(candidatoDTO);
    }

    @GetMapping(value = "/obtenerCandidatos")
    public List<Candidato> obtenerCandidatos(){
        return candidatoService.obtenerCandidatos();
    }

    @GetMapping(path = "/{idCandidato}")
    public Candidato buscarCandidatoPorId(@PathVariable("idCandidato") Long idCandidato){
        return candidatoService.buscarCandidatoPorId(idCandidato);
    }
/*
    @GetMapping(path = "/buscarCandidatoPorTecnologia")
    public List<Candidato> buscarCandidatoPorTecnologia(@RequestParam("tecnologia") String tecn){
        return candidatoServicie.findByTecnologia(tecn);
    } //  /api/candidato/buscarCandidatoPorTecnologia?tecnologia=tecn
*/

    @DeleteMapping(value = "/eliminarCandidatoPorId/{idCandidato}")
    public void eliminarCandidatoPorId(@PathVariable("idCandidato") Long idCandidato){
        candidatoService.eliminarCandidatoPorId(idCandidato);
    }

}
