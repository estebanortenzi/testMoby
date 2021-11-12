package servicies.impl;


import exceptions.TecnologiaNoEncontrada;
import models.enitities.Tecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.TecnologiaRepository;
import servicies.TecnologiaService;

import java.util.List;
import java.util.Optional;


@Service
public class TecnologiaServiceImpl implements TecnologiaService {

    @Autowired
    TecnologiaRepository tecnologiaRepository;


    public Tecnologia guardarTecnologia(Tecnologia tecnologia){

        return tecnologiaRepository.save(tecnologia);
    }

    public List<Tecnologia> obtenerTecnologia(){

        return tecnologiaRepository.findAll();
    }

    public void eliminarTecnologia(Tecnologia tecnologia){

        tecnologiaRepository.delete(tecnologia);
    }

    public Tecnologia buscarTecnologiaPorId(Tecnologia tecnologia){
        return tecnologiaRepository.findById(tecnologia.getIdTecnologia())
                .orElseThrow(()-> new TecnologiaNoEncontrada("No se encontro la tecnologia"));
    }

    public Tecnologia modificarTecnologia(Tecnologia tecnologia){
        Tecnologia tecnologiaBuscada = tecnologiaRepository.findById(tecnologia.getIdTecnologia()).orElseThrow();

        tecnologiaBuscada.setTipoTecnologia(tecnologia.getTipoTecnologia());
        tecnologiaBuscada.setVersion(tecnologia.getVersion());

        return tecnologiaRepository.save(tecnologiaBuscada);
    }

}
