package repositories;


import models.enitities.Candidato;
import models.enitities.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    List<Candidato> findByTecnologia(Tecnologia tecnologia);
}

