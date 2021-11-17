package com.example.demo.models.views;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoDTO {

    private Long idTipoDocumento;

    private String tipo;

}
