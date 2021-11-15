package com.example.demo.models.views;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TipoDocumentoDTO {

    private Long idTipoDocumento;

    private String tipo;

}
