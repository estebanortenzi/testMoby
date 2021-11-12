package com.example.demo.models.enitities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidatos")
public class Candidato implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato")
    private Long idCandidato;

    @NotEmpty(message = "completar nombre")
    private String nombre;

    @NotEmpty(message = "completar apellido")
    private String apellido;

    @NotEmpty(message = "completar el tipo de DNI")
    @JoinColumn(name = "id_tipo_dni", referencedColumnName = "id_tipo_dni")
    @OneToOne
    private TipoDNI tipoDNI;

    @NotEmpty(message = "completar DNI")
    private String dni;

    @NotEmpty(message = "completar fecha de nacimiento")
    @Column(name= "fecha_nacimiento")
    private Date fechaNacimiento;

}