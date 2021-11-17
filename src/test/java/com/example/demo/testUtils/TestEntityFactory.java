package com.example.demo.testUtils;

import com.example.demo.models.enitities.Candidato;
import com.example.demo.models.enitities.CandidatoPorTecnologia;
import com.example.demo.models.enitities.Tecnologia;
import com.example.demo.models.views.CandidatoPorTecnologiaDTO;
import com.example.demo.models.views.TecnologiaDTO;
import com.google.gson.Gson;
import com.example.demo.models.views.CandidatoDTO;

import java.util.LinkedList;
import java.util.List;

public class TestEntityFactory {

    public static final Long ID_CANDIDATO = 1L;
    public static final Long ID_TECNOLOGIA = 1L;
    public static final Long ID_CANDIDATO_X_TECNOLOGIA = 1L;
    public static final String DNI_CANDIDATO = "38932329";
    public static final String NOMBRE_TECNOLOGIA = "Java";

    public static CandidatoDTO getCandidatoDTOSinId(){
        return CandidatoDTO.builder()
                .nombre("Esteban")
                .apellido("Ortenzi")
                .tipoDocumento(null)
                .fechaNacimiento(null)
                .dni(DNI_CANDIDATO)
                .build();
    }

    public static CandidatoDTO getCandidatoDTOConId(){
        return CandidatoDTO.builder()
                .idCandidato(ID_CANDIDATO)
                .nombre("Esteban")
                .apellido("Ortenzi")
                .tipoDocumento(null)
                .fechaNacimiento(null)
                .dni(DNI_CANDIDATO)
                .build();
    }

    public static CandidatoDTO getCandidatoDTOSinIdSinDni(){
        return CandidatoDTO.builder()
                .nombre("Esteban")
                .apellido("Ortenzi")
                .tipoDocumento(null)
                .fechaNacimiento(null)
                .dni(null)
                .build();
    }

    public static CandidatoDTO getCandidatoDTOConIdModificado(){
        return CandidatoDTO.builder()
                .idCandidato(ID_CANDIDATO)
                .nombre("Lautaro")
                .apellido("Ortenzi")
                .tipoDocumento(null)
                .fechaNacimiento(null)
                .dni(DNI_CANDIDATO)
                .build();
    }

    public static List<CandidatoDTO> getListaCandidatosDTOConId(){

        List<CandidatoDTO> listaCandidatosDTO = new LinkedList<>();
        listaCandidatosDTO.add(getCandidatoDTOConId());

        return listaCandidatosDTO;
    }

    public static TecnologiaDTO getTecnologiaDTOConId(){
        return TecnologiaDTO.builder()
                .idTecnologia(ID_TECNOLOGIA)
                .nombre(NOMBRE_TECNOLOGIA)
                .version("8")
                .build();
    }

    public static TecnologiaDTO getTecnologiaDTOConIdModificado(){
        return TecnologiaDTO.builder()
                .idTecnologia(ID_TECNOLOGIA)
                .nombre("Java")
                .version("9")
                .build();
    }

    public static CandidatoPorTecnologiaDTO getCandidatoPorTecnologiaDTO(){
        return CandidatoPorTecnologiaDTO.builder()
                .idCandidatoXTecnologia(ID_CANDIDATO_X_TECNOLOGIA)
                .candidatoDTO(getCandidatoDTOConId())
                .tecnologiaDTO(getTecnologiaDTOConId())
                .build();
    }

    public static List<CandidatoPorTecnologiaDTO> getListaCandidatosPorTecnologiaDTO(){

        CandidatoPorTecnologiaDTO candidatoPorTecnologiaDTO = getCandidatoPorTecnologiaDTO();

        List<CandidatoPorTecnologiaDTO> listaCandidatosPorTecnologiaDTO = new LinkedList<>();

        listaCandidatosPorTecnologiaDTO.add(candidatoPorTecnologiaDTO);

        return listaCandidatosPorTecnologiaDTO;
    }

    public static List<TecnologiaDTO> getListaTecnologiasDTO(){
        List<TecnologiaDTO> listaTecnologiasDTO = new LinkedList<>();

        listaTecnologiasDTO.add(getTecnologiaDTOConId());

        return listaTecnologiasDTO;
    }

    public static String getCandidatoDtoConIdJson(){return new Gson().toJson(getCandidatoDTOConId());}

    public static String getCandidatoDTOConIdModificadoJson(){return new Gson().toJson(getCandidatoDTOConIdModificado());}

    public static TecnologiaDTO getTecnologiaDTOSinId(){
        return TecnologiaDTO.builder()
                .nombre("Java")
                .version("8")
                .build();
    }

    public static String getTecnologiaDTOConIdJson(){return new Gson().toJson(getTecnologiaDTOConId());}

    public static String getTecnologiaDTOSinIdJson(){return new Gson().toJson(getTecnologiaDTOSinId());}

    public static String getTecnologiaDTOConIdModificadoJson(){return new Gson().toJson(getTecnologiaDTOConIdModificado());}

    public static Candidato getCandidatoSinId(){
        return Candidato.builder()
                .nombre("Esteban")
                .apellido("Ortenzi")
                .dni(DNI_CANDIDATO)
                .fechaNacimiento(null)
                .tipoDocumento(null)
                .build();
    }

    public static Candidato getCandidatoConId(){
        return Candidato.builder()
                .idCandidato(ID_CANDIDATO)
                .nombre("Esteban")
                .apellido("Ortenzi")
                .dni(DNI_CANDIDATO)
                .fechaNacimiento(null)
                .tipoDocumento(null)
                .build();
    }

    public static List<Candidato> getListaCandidatos(){
        List<Candidato> listaCandidatos = new LinkedList<>();
        listaCandidatos.add(getCandidatoConId());

        return listaCandidatos;
    }

    public static Tecnologia getTecnologiaConId(){
        return Tecnologia.builder()
                .idTecnologia(ID_TECNOLOGIA)
                .nombre(NOMBRE_TECNOLOGIA)
                .version("8")
                .build();
    }

    public static CandidatoPorTecnologia getCandidatoPorTecnologia(){
        return CandidatoPorTecnologia.builder()
                .idCandidatoXTecnologia(ID_CANDIDATO_X_TECNOLOGIA)
                .candidato(getCandidatoConId())
                .tecnologia(getTecnologiaConId())
                .build();
    }

    public static List<CandidatoPorTecnologia> getListaCandidatosPorTecnologia(){

        CandidatoPorTecnologia candidatoPorTecnologia = getCandidatoPorTecnologia();

        List<CandidatoPorTecnologia> listaCandidatosPorTecnologia = new LinkedList<>();

        listaCandidatosPorTecnologia.add(candidatoPorTecnologia);

        return listaCandidatosPorTecnologia;
    }

    public static Tecnologia getTecnologiaSinId(){
        return Tecnologia.builder()
                .nombre(NOMBRE_TECNOLOGIA)
                .version("8")
                .build();
    }

    public static List<Tecnologia> getListaTecnologias(){
        List<Tecnologia> listaTecnologias = new LinkedList<>();

        listaTecnologias.add(getTecnologiaConId());

        return listaTecnologias;
    }

}
