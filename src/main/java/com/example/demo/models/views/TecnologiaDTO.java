package com.example.demo.models.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TecnologiaDTO {

    private Long idTecnologia;

    private String nombre;

    private String version;

}
