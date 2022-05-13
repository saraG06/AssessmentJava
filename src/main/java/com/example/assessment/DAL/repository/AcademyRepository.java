package com.example.assessment.DAL.repository;

import com.example.assessment.DAL.entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {

    @Query(value = "SELECT a FROM Academy a")
    Academy getAcademy();

    @Query("SELECT a FROM Academy a WHERE a.nome=:nome")
    Academy getAcademyByNome(@Param("nome") String nome);
}
