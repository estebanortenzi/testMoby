package servicies;

import models.enitities.Tecnologia;

import java.util.List;

public interface TecnologiaService {

    Tecnologia guardarTecnologia(Tecnologia tecnologia);

    List<Tecnologia> obtenerTecnologia();

    void eliminarTecnologia(Tecnologia tecnologia);

    Tecnologia buscarTecnologiaPorId(Tecnologia tecnologia);

    Tecnologia modificarTecnologia(Tecnologia tecnologia);

}
