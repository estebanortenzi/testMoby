package com.example.demo.servicesImpl;

import com.example.demo.exceptions.IdEncontradoException;
import com.example.demo.models.enitities.Tecnologia;
import com.example.demo.models.views.TecnologiaDTO;
import com.example.demo.repositories.TecnologiaRepository;
import com.example.demo.servicies.TecnologiaService;
import com.example.demo.servicies.impl.TecnologiaServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.example.demo.testUtils.TestEntityFactory.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = TecnologiaServiceImpl.class)
public class TecnologiaServiceImplTest {

    @InjectMocks
    TecnologiaServiceImpl tecnologiaServiceImpl;

    @Mock
    TecnologiaRepository tecnologiaRepository;

    @MockBean
    TecnologiaService tecnologiaService;

    @Autowired
    private MockMvc mockMvc;

    @Spy
    private ModelMapper modelMapper;

    @Test
    @WithMockUser
    void guardarTecnologiaTest(){
        when(modelMapper.map(getTecnologiaDTOSinId(), Tecnologia.class)).thenReturn(getTecnologiaSinId());
        when(tecnologiaRepository.save(getTecnologiaSinId())).thenReturn(getTecnologiaConId());

        TecnologiaDTO tecnologiaDTO = tecnologiaServiceImpl.guardarTecnologia(getTecnologiaDTOSinId());

        assertEquals(getTecnologiaDTOConId(), tecnologiaDTO);
    }

    @Test
    @WithMockUser
    void modificarTecnologiaTest(){
        when(modelMapper.map(getTecnologiaDTOConId(), Tecnologia.class)).thenReturn(getTecnologiaConId());
        when(tecnologiaRepository.save(getTecnologiaConId())).thenReturn(getTecnologiaConId());

        TecnologiaDTO tecnologiaDTO = tecnologiaServiceImpl.modificarTecnologia(getTecnologiaDTOConId());

        assertEquals(getTecnologiaDTOConId(), tecnologiaDTO);
    }

    @Test
    @WithMockUser
    void obtenerTecnologiasTest(){
        when(tecnologiaRepository.findAll()).thenReturn(getListaTecnologias());

        List<TecnologiaDTO> lista = tecnologiaServiceImpl.obtenerTecnologias();

        assertEquals(getListaTecnologiasDTO(), lista);
    }

    //Problemas con el tecnologiaRepository.findById. Preguntarle a Javi como solucionarlo!!!
    @Test
    @WithMockUser
    void eliminarTecnologiaTest(){
        tecnologiaServiceImpl.eliminarTecnologiaPorId(ID_TECNOLOGIA);
        verify(tecnologiaRepository, times(1)).deleteById(ID_TECNOLOGIA);
    }

}
