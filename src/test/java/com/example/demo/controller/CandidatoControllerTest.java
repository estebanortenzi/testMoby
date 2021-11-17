package com.example.demo.controller;

import com.example.demo.exceptions.DniInexistenteExcpetion;
import com.example.demo.exceptions.IdNoEncontradoException;
import com.example.demo.servicies.CandidatoService;
import org.junit.jupiter.api.Test;
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

@WebMvcTest(controllers = CandidatoController.class)
public class CandidatoControllerTest {


    @MockBean
    CandidatoService candidatoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void guardarCandidatoTest() throws Exception{
        when(candidatoService.guardarCandidato(getCandidatoDTOSinId())).thenReturn(getCandidatoDTOConId());
        mockMvc.perform(post("/api/candidato/guardarCandidato", getCandidatoDtoConIdJson())
                .contentType(MediaType.APPLICATION_JSON)
                .content(getCandidatoDtoConIdJson()))
        .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser
    void guardarCandidatoFailTest() throws Exception{

        when(candidatoService.guardarCandidato(getCandidatoDTOSinIdSinDni())).thenThrow(DniInexistenteExcpetion.class);
        mockMvc.perform(post("/api/candidato/guardarCandidato", getCandidatoDTOSinIdSinDni()))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser
    void modificarCandidatoTest() throws Exception{
        when(candidatoService.modificarCandidato(getCandidatoDTOConId())).thenReturn(getCandidatoDTOConIdModificado());
        mockMvc.perform(post("/api/candidato/modificarCandidato", getCandidatoDTOConIdModificadoJson())
                .contentType(MediaType.APPLICATION_JSON)
                .content(getCandidatoDTOConIdModificadoJson()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void modificarCandidatoFailTest() throws Exception{
        when(candidatoService.modificarCandidato(getCandidatoDTOConId())).thenThrow(IdNoEncontradoException.class);
        mockMvc.perform(post("/api/candidato/modificarCandidato", getCandidatoDTOConIdModificadoJson()))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser
    void obtenerCandidatosTest() throws Exception{
        when(candidatoService.obtenerCandidatos()).thenReturn(getListaCandidatosDTOConId());
        mockMvc.perform(get("/api/candidato/obtenerCandidatos"))
                .andExpect(status().isOk());
    }

     @Test
    @WithMockUser
    void eliminarCandidatoTest() throws Exception{
        mockMvc.perform(delete("/api/candidato/eliminarCandidatoPorId/{idCandidato}", ID_CANDIDATO))
                 .andExpect(status().isOk());
         verify(candidatoService, times(1)).eliminarCandidatoPorId(ID_CANDIDATO);
     }

    @Test
    @WithMockUser
    void buscarCandidatoPorDniTest() throws Exception{
        when(candidatoService.buscarCandidatoPorDni(DNI_CANDIDATO)).thenReturn(getCandidatoDTOConId());
        mockMvc.perform(get("/api/candidato/buscarCandidatoPorDni/{dniCandidato}", DNI_CANDIDATO))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void listarCandidatosPorTecnologia() throws Exception{
        when(candidatoService.listarCandidatoPorTecnologia(NOMBRE_TECNOLOGIA)).thenReturn(getListaCandidatosPorTecnologiaDTO());
        mockMvc.perform(get("/api/candidato/listarCandidatosPorTecnologia/{nombreTecnologia}", NOMBRE_TECNOLOGIA))
                .andExpect(status().isOk());
    }

}
