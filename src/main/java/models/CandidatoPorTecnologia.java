package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidato_x_tecnologia")
public class CandidatoPorTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_candidato_x_experiencia")
    private Long idCandidatoXTecnologia;

    @JoinColumn(name= "id_candidato", referencedColumnName = "id_candidato")
    @ManyToOne(fetch = FetchType.EAGER)
    private Candidato candidato;

    @JoinColumn(name= "id_tecnologia", referencedColumnName = "id_tecnologia")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tecnologia tecnologia;

    @NotEmpty(message = "completar años de experiencia")
    @Column(name= "anios_experiencia")
    private int aniosExperiencia;



}
