package com.example.assessmentjava.DAL.Repository;

import com.example.assessmentjava.DAL.Entity.Discente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscenteRepository extends JpaRepository<Discente,Long> {


}
