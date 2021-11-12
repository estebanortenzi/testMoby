package servicies.impl;

import exceptions.CandidatoNoEncontrado;
import models.enitities.Candidato;
import models.enitities.Tecnologia;
import models.views.CandidatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CandidatoRepository;
import servicies.CandidatoServicie;

import java.util.List;

@Service
public class CandidatoServiceImpl implements CandidatoServicie {

    @Autowired
    CandidatoRepository candidatoRepository;

    public void guardarCandidato(CandidatoDTO candidatoDTO){

        Candidato candidato = Candidato.builder()
                .nombre(candidatoDTO.getNombre())
                .apellido(candidatoDTO.getApellido())
                .dni(candidatoDTO.getDni())
                .fechaNacimiento(candidatoDTO.getFechaNacimiento())
                .tipoDNI(candidatoDTO.getTipoDNI())
                .build();

         candidatoRepository.save(candidato);
    }

    public List<Candidato> obtenerCandidatos(){
        return candidatoRepository.findAll();
    }

    public void eliminarCandidatoPorId(Long idCandidatoDTO){
            candidatoRepository.deleteById(idCandidatoDTO);
    }

    public Candidato buscarCandidatoPorId(Long idCandidato){
        return candidatoRepository.findById(idCandidato)
                .orElseThrow(() -> new CandidatoNoEncontrado("No se encontró el candidato")); //Supplier, no recibe parametros porque es un proveedor
    }

    public Candidato modificarCandidato(CandidatoDTO candidatoDTO){
        Candidato candidatoBuscado = this.buscarCandidatoPorId(candidatoDTO.getIdCandidato());

        candidatoBuscado.setNombre(candidatoDTO.getNombre());
        candidatoBuscado.setApellido(candidatoDTO.getApellido());
        candidatoBuscado.setTipoDNI(candidatoDTO.getTipoDNI());
        candidatoBuscado.setDni(candidatoDTO.getDni());
        candidatoBuscado.setFechaNacimiento(candidatoDTO.getFechaNacimiento());

        return candidatoRepository.save(candidatoBuscado);
    }

    public List<Candidato> findByTecnologia(Tecnologia tecnologia) {
        return candidatoRepository.findByTecnologia(tecnologia);
    }


}
