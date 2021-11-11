package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidatos")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idCandidato;

    private String nombre;
    private String apellido;
    private String tipoDNI; // HACER ENUM
    private String dni;
    private String fechaNacimiento;
    private List <Tecnologia> tecnologias;


}