package models.enitities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidato_x_tecnologia")
public class CandidatoPorTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_candidato_x_tecnologia")
    private Long idCandidatoXTecnologia;

    @JoinColumn(name= "id_candidato", referencedColumnName = "id_candidato")
    @ManyToOne(fetch = FetchType.EAGER) // Preguntar Javi
    private Candidato candidato;

    @JoinColumn(name= "id_tecnologia", referencedColumnName = "id_tecnologia")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tecnologia tecnologia;

    @NotEmpty(message = "completar años de experiencia")
    @Column(name= "anios_experiencia")
    private int aniosExperiencia;



}
