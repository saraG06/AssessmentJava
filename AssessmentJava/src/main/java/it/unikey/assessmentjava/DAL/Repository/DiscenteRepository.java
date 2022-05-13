package it.unikey.assessmentjava.DAL.Repository;

import it.unikey.assessmentjava.DAL.Entity.Discente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscenteRepository extends JpaRepository<Discente, Long> {
}
