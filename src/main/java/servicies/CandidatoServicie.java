package servicies;

import models.enitities.Candidato;
import models.enitities.Tecnologia;
import models.views.CandidatoDTO;

import java.util.List;

public interface CandidatoServicie {

    void guardarCandidato(CandidatoDTO candidatoDTO);

    List<Candidato> obtenerCandidatos();

    void eliminarCandidatoPorId(Long idCandidatoDTO);

    Candidato buscarCandidatoPorId(Long idCandidato);

    Candidato modificarCandidato(CandidatoDTO candidatoDTO);

    List<Candidato> findByTecnologia(Tecnologia tecnologia);

}
