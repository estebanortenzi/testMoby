package servicies.impl;


import models.Tecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.TecnologiaRepository;

import java.util.List;
import java.util.Optional;

public class TecnologiaServiceImpl {

    @Autowired
    TecnologiaRepository tecnologiaRepository;


    public Tecnologia guardarTecnologia(Tecnologia tecnologia){
        return tecnologiaRepository.save(tecnologia);
    }

    public List<Tecnologia> obtenerCandidatos(){
        return tecnologiaRepository.findAll();
    }

    public void eliminarCandidato(Tecnologia tecnologia){
        tecnologiaRepository.delete(tecnologia);
    }

    public Optional<Tecnologia> buscarCandidatoPorId(Tecnologia tecnologia){
        return tecnologiaRepository.findById(tecnologia.getIdTecnologia());
    }

    public Tecnologia modificarCandidato(Tecnologia tecnologia){
        Tecnologia tecnologiaBuscada = tecnologiaRepository.findById(tecnologia.getIdTecnologia()).orElseThrow();

        tecnologiaBuscada.setNombre(tecnologia.getNombre());
        tecnologiaBuscada.setVersion(tecnologia.getVersion());

        return tecnologiaRepository.save(tecnologiaBuscada);
    }

}
