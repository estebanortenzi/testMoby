package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidato_x_tecnologia")
public class CandidatoPorTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_candidato_x_experiencia", unique = true, nullable = false)
    private Long idCandidatoXTecnologia;

    @JoinColumn(name= "id_candidato", referencedColumnName = "id_candidato")
    @ManyToOne
    private Candidato candidato;

    @JoinColumn(name= "id_tecnologia", referencedColumnName = "id_tecnologia")
    @ManyToOne
    private Tecnologia tecnologia;

    @Column(name= "anios_experiencia")
    private int aniosExperiencia;



}
