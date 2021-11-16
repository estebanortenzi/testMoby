package com.example.demo.models.views;

import com.example.demo.models.enitities.Candidato;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TecnologiaDTO {

    private Long idTecnologia;

    private String nombre;

    private String version;

}
