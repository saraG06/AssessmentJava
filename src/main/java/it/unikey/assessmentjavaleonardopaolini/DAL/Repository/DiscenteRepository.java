package it.unikey.assessmentjavaleonardopaolini.DAL.Repository;

import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Discente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscenteRepository extends JpaRepository<Discente,Long> {
}
