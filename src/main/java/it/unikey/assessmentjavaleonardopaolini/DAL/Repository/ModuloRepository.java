package it.unikey.assessmentjavaleonardopaolini.DAL.Repository;

import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo,Long> {
}
