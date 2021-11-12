package servicies.impl;

import exceptions.TecnologiaNoEncontrada;
import models.enitities.Tecnologia;
import models.views.TecnologiaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.TecnologiaRepository;
import servicies.TecnologiaService;

import java.util.List;

@Service
public class TecnologiaServiceImpl implements TecnologiaService {

    @Autowired
    TecnologiaRepository tecnologiaRepository;


    public void guardarTecnologia(TecnologiaDTO tecnologiaDTO){
        Tecnologia tecnologia = Tecnologia.builder()
                .tipoTecnologia(tecnologiaDTO.getTipoTecnologia())
                .version(tecnologiaDTO.getVersion())
                .build();

         tecnologiaRepository.save(tecnologia);
    }

    public List<Tecnologia> obtenerTecnologias(){

        return tecnologiaRepository.findAll();
    }

    public void eliminarTecnologiaPorId(Long idTecnologia){

        tecnologiaRepository.deleteById(idTecnologia);
    }

    public Tecnologia buscarTecnologiaPorId(Long idTecnologia){
        return tecnologiaRepository.findById(idTecnologia)
                .orElseThrow(()-> new TecnologiaNoEncontrada("No se encontro la tecnologia"));
    }

    public Tecnologia modificarTecnologia(TecnologiaDTO tecnologiaDTO){
        Tecnologia tecnologiaBuscada = this.buscarTecnologiaPorId(tecnologiaDTO.getIdTecnologia());

        tecnologiaBuscada.setTipoTecnologia(tecnologiaDTO.getTipoTecnologia());
        tecnologiaBuscada.setVersion(tecnologiaDTO.getVersion());

        return tecnologiaRepository.save(tecnologiaBuscada);
    }

}
