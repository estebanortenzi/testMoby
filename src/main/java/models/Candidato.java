package models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;


@Entity
@Data
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

    @NotEmpty(message = "completar TipoDNI")
    @Column(name= "tipo_dni")
    private TipoDNI tipoDNI;

    @NotEmpty(message = "completar DNI")
    private String dni;

    @NotEmpty(message = "completar fecha de nacimiento")
    @Column(name= "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;



}