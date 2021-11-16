package com.example.demo.testUtils;

import com.example.demo.models.views.CandidatoPorTecnologiaDTO;
import com.example.demo.models.views.TecnologiaDTO;
import com.google.gson.Gson;
import com.example.demo.models.views.CandidatoDTO;

import java.util.LinkedList;
import java.util.List;

public class TestEntityFactory {

    public static final Long ID_CANDIDATO_DTO = 1L;
    public static final Long ID_TECNOLOGIA_DTO = 1L;
    public static final Long ID_CANDIDATO_X_TECNOLOGIA_DTO = 1L;
    public static final String DNI_CANDIDATO_DTO = "38932329";
    public static final String NOMBRE_TECNOLOGIA = "Java";

    public static CandidatoDTO getCandidatoDTOSinId(){
        return CandidatoDTO.builder()
                .nombre("Esteban")
                .apellido("Ortenzi")
                .tipoDocumento(null)
                .fechaNacimiento(null)
                .dni("DNI_CANDIDATO_DTO")
                .build();
    }

    public static CandidatoDTO getCandidatoDTOConId(){
        return CandidatoDTO.builder()
                .idCandidato(ID_CANDIDATO_DTO)
                .nombre("Esteban")
                .apellido("Ortenzi")
                .tipoDocumento(null)
                .fechaNacimiento(null)
                .dni("DNI_CANDIDATO_DTO")
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
                .idCandidato(ID_CANDIDATO_DTO)
                .nombre("Lautaro")
                .apellido("Ortenzi")
                .tipoDocumento(null)
                .fechaNacimiento(null)
                .dni("DNI_CANDIDATO_DTO")
                .build();
    }

    public static List<CandidatoDTO> getListaCandidatosDTOConId(){

        List<CandidatoDTO> listaCandidatosDTO = new LinkedList<>();
        listaCandidatosDTO.add(getCandidatoDTOConId());

        return listaCandidatosDTO;
    }

    public static TecnologiaDTO getTecnologiaDTO(){
        return TecnologiaDTO.builder()
                .idTecnologia(ID_TECNOLOGIA_DTO)
                .nombre("Java")
                .version("8")
                .build();
    }

    public static CandidatoPorTecnologiaDTO getCandidatoPorTecnologiaDTO(){
        return CandidatoPorTecnologiaDTO.builder()
                .idCandidatoXTecnologia(ID_CANDIDATO_X_TECNOLOGIA_DTO)
                .candidatoDTO(getCandidatoDTOConId())
                .tecnologiaDTO(getTecnologiaDTO())
                .build();
    }

    public static List<CandidatoPorTecnologiaDTO> getListaCandidatosPorTecnologiaDTO(){

        CandidatoPorTecnologiaDTO candidatoPorTecnologiaDTO = getCandidatoPorTecnologiaDTO();

        List<CandidatoPorTecnologiaDTO> listaCandidatosPorTecnologiaDTO = new LinkedList<>();

        listaCandidatosPorTecnologiaDTO.add(candidatoPorTecnologiaDTO);

        return listaCandidatosPorTecnologiaDTO;
    }

    public static String getCandidatoDtoConIdJson(){return new Gson().toJson(getCandidatoDTOConId());}

    public static String getCandidatoDTOConIdModificadoJson(){return new Gson().toJson(getCandidatoDTOConIdModificado());}

}
