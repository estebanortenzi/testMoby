package com.example.demo.repositories;


import com.example.demo.models.enitities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    Candidato findByDni(String dni);

}

