package com.example.assessmentfinale.DAL.repository;

import com.example.assessmentfinale.DAL.entities.Academy;
import com.example.assessmentfinale.DAL.entities.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {




}
