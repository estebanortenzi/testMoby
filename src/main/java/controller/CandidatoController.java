package controller;


import lombok.extern.java.Log;
import models.enitities.Candidato;
import models.enitities.Tecnologia;
import models.views.CandidatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import servicies.CandidatoServicie;

import java.util.List;

@Log
@RestController
@RequestMapping(value = "/api/candidato")
public class CandidatoController {

    @Autowired
    CandidatoServicie candidatoServicie;

    @PostMapping(value = "/guardarCandidato")
    public void guardarCandidato(@RequestBody CandidatoDTO candidatoDTO){
        candidatoServicie.guardarCandidato(candidatoDTO);
    }

    @GetMapping(value = "/obtenerCandidatos")
    public List<Candidato> obtenerCandidatos(){
        return candidatoServicie.obtenerCandidatos();
    }

    @GetMapping(path = "/{idCandidato}")
    public Candidato buscarCandidatoPorId(@PathVariable("idCandidato") Long idCandidato){
        return candidatoServicie.buscarCandidatoPorId(idCandidato);
    }

    @GetMapping(path = "/buscarCandidatoPorTecnologia")
    public List<Candidato> buscarCandidatoPorTecnologia(@RequestParam("tecnologia") Tecnologia tecn){
        return candidatoServicie.findByTecnologia(tecn);
    } //  /api/candidato/buscarCandidatoPorTecnologia?tecnologia=tecn


    @DeleteMapping(value = "/eliminarCandidatoPorId/{idCandidato}")
    public void eliminarCandidatoPorId(@PathVariable("idCandidato") Long idCandidato){
        candidatoServicie.eliminarCandidatoPorId(idCandidato);
    }

}
