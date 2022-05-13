package it.unikey.testfinale.DAL.Repository;

import it.unikey.testfinale.DAL.Entity.Discente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscenteRepository extends JpaRepository<Discente, Long> {
}
