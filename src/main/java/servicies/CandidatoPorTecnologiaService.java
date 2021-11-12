package servicies;

import models.enitities.CandidatoPorTecnologia;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CandidatoPorTecnologiaService {

    CandidatoPorTecnologia guardarCandidatoPorTecnologia(CandidatoPorTecnologia candidatoPorTecnologia);

    List<CandidatoPorTecnologia> obtenerCandidatosPorTecnologia();

    void eliminarCandidatoPorTecnologia(CandidatoPorTecnologia candidatoPorTecnologia);

    CandidatoPorTecnologia buscarCandidatoPorTecnologiaPorId(CandidatoPorTecnologia candidatoPorTecnologia);

    CandidatoPorTecnologia modificarCandidatoPorTecnologia(CandidatoPorTecnologia candidatoPorTecnologia);



}
