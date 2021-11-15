package com.example.demo.models.views;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDNIDto {

    private Long idTipoDNI;

    private String tipo;

}
