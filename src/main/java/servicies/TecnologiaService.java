package servicies;

import models.enitities.Tecnologia;
import models.views.TecnologiaDTO;

import java.util.List;

public interface TecnologiaService {

    void guardarTecnologia(TecnologiaDTO tecnologiaDTO);

    List<Tecnologia> obtenerTecnologias();

    void eliminarTecnologiaPorId(Long idTecnologia);

    Tecnologia buscarTecnologiaPorId(Long idTecnologia);

    Tecnologia modificarTecnologia(TecnologiaDTO tecnologiaDTO);

}
