package com.example.demo.servicesImpl;


import com.example.demo.models.enitities.CandidatoPorTecnologia;
import com.example.demo.models.views.CandidatoPorTecnologiaDTO;
import com.example.demo.repositories.CandidatoPorTecnologiaRepository;
import com.example.demo.servicies.CandidatoPorTecnologiaService;
import com.example.demo.servicies.impl.CandidatoPorTecnologiaServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static com.example.demo.testUtils.TestEntityFactory.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CandidatoPorTecnologiaServiceImpl.class)
public class CandidatoPorTecnologiaServiceImplTest {

    @InjectMocks
    CandidatoPorTecnologiaServiceImpl candidatoPorTecnologiaServiceImpl;

    @Mock
    CandidatoPorTecnologiaRepository candidatoPorTecnologiaRepository;

    @MockBean
    CandidatoPorTecnologiaService candidatoPorTecnologiaService;

    @Spy
    private ModelMapper modelMapper;

    @Test
    @WithMockUser
    void guardarCandidatoPorTecnologiaTest(){
        when(modelMapper.map(getCandidatoPorTecnologiaDTOSinId(), CandidatoPorTecnologia.class)).thenReturn(getCandidatoPorTecnologiaSinId());
        when(candidatoPorTecnologiaRepository.save(getCandidatoPorTecnologiaSinId())).thenReturn(getCandidatoPorTecnologia());

        CandidatoPorTecnologiaDTO candidatoPorTecnologiaDTO = candidatoPorTecnologiaServiceImpl.guardarCandidatoPorTecnologia(getCandidatoPorTecnologiaDTOSinId());
    }

    @Test
    @WithMockUser
    void modificarCandidatoPorTecnologiaTest(){
        when(modelMapper.map(getCandidatoPorTecnologiaDTO(), CandidatoPorTecnologia.class)).thenReturn(getCandidatoPorTecnologia());
        when(candidatoPorTecnologiaRepository.save(getCandidatoPorTecnologia())).thenReturn(getCandidatoPorTecnologia());

        CandidatoPorTecnologiaDTO candidatoPorTecnologiaDTO = candidatoPorTecnologiaServiceImpl.modificarCandidatoPorTecnologia(getCandidatoPorTecnologiaDTO());
    }

    @Test
    @WithMockUser
    void obtenerCandidatosPorTecnologiaTest(){
        when(candidatoPorTecnologiaRepository.findAll()).thenReturn(getListaCandidatosPorTecnologia());

        List<CandidatoPorTecnologiaDTO> lista = candidatoPorTecnologiaServiceImpl.obtenerCandidatosPorTecnologias();
    }

}
