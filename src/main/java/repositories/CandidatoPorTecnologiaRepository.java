package repositories;

import models.CandidatoPorTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoPorTecnologiaRepository extends JpaRepository<CandidatoPorTecnologia, Long> {
}
