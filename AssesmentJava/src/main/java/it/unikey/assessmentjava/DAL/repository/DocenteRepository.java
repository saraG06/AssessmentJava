package it.unikey.assessmentjava.DAL.repository;

import it.unikey.assessmentjava.DAL.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
}
