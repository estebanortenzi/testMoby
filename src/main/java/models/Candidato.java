package models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import java.util.Date;


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

    @Column(name= "tipo_dni")
    private TipoDNI tipoDNI;

    @NotNull
    private String dni;

    @NotNull
    @Column(name= "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;



}