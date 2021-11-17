package com.example.demo.servicesImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.exceptions.DniInexistenteExcpetion;
import com.example.demo.exceptions.IdNoEncontradoException;
import com.example.demo.models.enitities.Candidato;
import com.example.demo.models.views.CandidatoDTO;
import com.example.demo.models.views.CandidatoPorTecnologiaDTO;
import com.example.demo.repositories.CandidatoPorTecnologiaRepository;
import com.example.demo.repositories.CandidatoRepository;
import com.example.demo.servicies.CandidatoService;
import com.example.demo.servicies.impl.CandidatoServiceImpl;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = CandidatoServiceImpl.class)
public class CandidatoServiceImplTest {

    @InjectMocks
    CandidatoServiceImpl candidatoServiceImpl;

    @Mock
    CandidatoRepository candidatoRepository;

    @Mock
    CandidatoPorTecnologiaRepository candidatoPorTecnologiaRepository;

    @MockBean
    CandidatoService candidatoService;  // Si no está se rompen todos los tests.

    @Spy
    private ModelMapper modelMapper;

    @Test
    @WithMockUser
    void guardarCandidatoTest(){
        when(modelMapper.map(getCandidatoDTOSinId(), Candidato.class)).thenReturn(getCandidatoSinId());
        when(candidatoRepository.save(getCandidatoSinId())).thenReturn(getCandidatoConId());
        when(modelMapper.map(getCandidatoConId(), CandidatoDTO.class)).thenReturn(getCandidatoDTOConId());

        CandidatoDTO candidatoDTO = candidatoServiceImpl.guardarCandidato(getCandidatoDTOSinId());

        assertEquals(getCandidatoDTOConId(), candidatoDTO);
    }

    @Test
    @WithMockUser
    void guardarCandidatoFailTest(){
        assertThrows(DniInexistenteExcpetion.class, ()-> candidatoServiceImpl.guardarCandidato(getCandidatoDTOSinIdSinDni()));
    }

    @Test
    @WithMockUser
    void modificarCandidatoTest(){
        when(modelMapper.map(getCandidatoDTOConId(), Candidato.class)).thenReturn(getCandidatoConId());
        when(candidatoRepository.save(getCandidatoConId())).thenReturn(getCandidatoConId());
        when(modelMapper.map(getCandidatoConId(), CandidatoDTO.class)).thenReturn(getCandidatoDTOConId());

        CandidatoDTO candidatoDTO = candidatoServiceImpl.modificarCandidato(getCandidatoDTOConId());

        assertEquals(getCandidatoDTOConId(), candidatoDTO);
    }

    @Test
    @WithMockUser
    void modificarCandidatoFailTest(){
        assertThrows(IdNoEncontradoException.class, ()-> candidatoServiceImpl.modificarCandidato(getCandidatoDTOSinIdSinDni()));
    }

    @Test
    @WithMockUser
    void obtenerCandidatosTest(){
        when(candidatoRepository.findAll()).thenReturn(getListaCandidatos());

        List<CandidatoDTO> lista = candidatoServiceImpl.obtenerCandidatos();

        assertEquals(getListaCandidatosDTOConId(), lista);
    }

    @Test
    @WithMockUser
    void eliminarCandidatoPorIdTest(){
        candidatoServiceImpl.eliminarCandidatoPorId(ID_CANDIDATO);
        verify(candidatoRepository, times(1)).deleteById(ID_CANDIDATO);
    }

    @Test
    @WithMockUser
    void buscarCandidatoPorDniTest(){
        when(candidatoRepository.findByDni(DNI_CANDIDATO)).thenReturn(getCandidatoConId());
        when(modelMapper.map(getCandidatoConId(), CandidatoDTO.class)).thenReturn(getCandidatoDTOConId());

        CandidatoDTO candidatoDTO = candidatoServiceImpl.buscarCandidatoPorDni(DNI_CANDIDATO);

        assertEquals(getCandidatoDTOConId(), candidatoDTO);
    }

    @Test
    @WithMockUser
    void buscarCandidatoPorDniFailTest(){
        assertThrows(DniInexistenteExcpetion.class, ()-> candidatoServiceImpl.buscarCandidatoPorDni(DNI_CANDIDATO));
    }

    @Test
    @WithMockUser
    void listarCandidatosPorTecnologiaTest(){
        when(candidatoPorTecnologiaRepository.findCandidatosPorTecnologiaByTecnologia(NOMBRE_TECNOLOGIA)).thenReturn(getListaCandidatosPorTecnologia());

        List<CandidatoPorTecnologiaDTO> lista = candidatoServiceImpl.listarCandidatoPorTecnologia(NOMBRE_TECNOLOGIA);

    }

}
