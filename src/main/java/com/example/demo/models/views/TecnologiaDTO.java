package com.example.demo.models.views;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TecnologiaDTO {

    private Long idTecnologia;

    private String nombre;

    private String version;

}
