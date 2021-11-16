package com.example.demo.repositories;

import com.example.demo.models.enitities.CandidatoPorTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoPorTecnologiaRepository extends JpaRepository<CandidatoPorTecnologia, Long> {

    @Query(value = "SELECT cxt.id_candidato_x_tecnologia, cxt.id_candidato, cxt.id_tecnologia, cxt.anios_experiencia"
            + " FROM candidato_x_tecnologia cxt "
            + " INNER JOIN tecnologias tecn ON cxt.id_tecnologia = tecn.id_tecnologia"
            + " WHERE tecn.nombre LIKE ?1", nativeQuery = true)
    List<CandidatoPorTecnologia> findCandidatosPorTecnologiaByTecnologia(String nombreTecnologia);


}
