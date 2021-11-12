package models.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.enums.TipoTecnologia;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecnologiaDTO {

    private Long idTecnologia;

    private TipoTecnologia tipoTecnologia;

    private String version;

}
