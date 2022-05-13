package com.example.assessmentjava.DAL.Repository;

import com.example.assessmentjava.DAL.Entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {
    @Query("select a from Academy a where a.nome like %:nome%")
    List<Academy> findByName(@Param("nome") String nome);
}
