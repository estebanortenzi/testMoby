package com.example.demo.repositories;

import com.example.demo.models.enitities.TipoDNI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDNIRepository extends JpaRepository<TipoDNI, Long> {

}
