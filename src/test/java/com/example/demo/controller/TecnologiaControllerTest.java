package com.example.demo.controller;

import com.example.demo.exceptions.IdEncontradoException;
import com.example.demo.exceptions.IdNoEncontradoException;
import com.example.demo.servicies.TecnologiaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.demo.testUtils.TestEntityFactory.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TecnologiaController.class)
public class TecnologiaControllerTest {

    @MockBean
    TecnologiaService tecnologiaService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @WithMockUser
    void guardarTecnologia() throws Exception{
        when(tecnologiaService.guardarTecnologia(getTecnologiaDTOSinId())).thenReturn(getTecnologiaDTOConId());
        mockMvc.perform(post("/api/tecnologia/guardarTecnologia", getTecnologiaDTOConIdJson())
        .contentType(MediaType.APPLICATION_JSON)
        .content(getTecnologiaDTOConIdJson()))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser
    void guardarTecnologiaFailTest() throws Exception{
        when(tecnologiaService.guardarTecnologia(getTecnologiaDTOConId())).thenThrow(IdEncontradoException.class);
        mockMvc.perform(post("/api/tecnologia/guardarTecnologia", getTecnologiaDTOSinIdJson()))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser
    void modificarTecnologiaTest() throws Exception{
        when(tecnologiaService.modificarTecnologia(getTecnologiaDTOConId())).thenReturn(getTecnologiaDTOConIdModificado());
        mockMvc.perform(post("/api/tecnologia/modificarTecnologia", getTecnologiaDTOConIdModificadoJson())
        .contentType(MediaType.APPLICATION_JSON)
        .content(getTecnologiaDTOConIdModificadoJson()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void modificarTecnologiaFailTest() throws Exception{
        when(tecnologiaService.modificarTecnologia(getTecnologiaDTOConId())).thenThrow(IdNoEncontradoException.class);
        mockMvc.perform(post("/api/tecnologia/modificarTecnologia", getTecnologiaDTOConIdModificadoJson()))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser
    void obtenerTecnologiasTest() throws Exception{
        when(tecnologiaService.obtenerTecnologias()).thenReturn(getListaTecnologiasDTO());
        mockMvc.perform(get("/api/tecnologia/obtenerTecnologias"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void buscarTecnologiaPorIdTest() throws Exception{
        when(tecnologiaService.buscarTecnologiaPorId(ID_TECNOLOGIA_DTO)).thenReturn(getTecnologiaDTOConId());
        mockMvc.perform(get("/api/tecnologia/buscarTecnologiaPorId/{idTecnologia}", ID_TECNOLOGIA_DTO))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void eliminarTecnologiaTest() throws Exception{
        mockMvc.perform(delete("/api/tecnologia/eliminarTecnologiaPorId/{idTecnologia}", ID_TECNOLOGIA_DTO))
                .andExpect(status().isOk());
        verify(tecnologiaService, times(1)).eliminarTecnologiaPorId(ID_TECNOLOGIA_DTO);
    }

}
