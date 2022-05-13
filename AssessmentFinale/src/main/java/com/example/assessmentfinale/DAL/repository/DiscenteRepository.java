package com.example.assessmentfinale.DAL.repository;

import com.example.assessmentfinale.DAL.entities.Discente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscenteRepository extends JpaRepository<Discente, Long> {
}
