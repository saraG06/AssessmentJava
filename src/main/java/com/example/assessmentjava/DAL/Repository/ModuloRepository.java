package com.example.assessmentjava.DAL.Repository;

import com.example.assessmentjava.DAL.Entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {
}
