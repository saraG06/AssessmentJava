package it.unikey.testfinale.DAL.Repository;

import it.unikey.testfinale.DAL.Entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
}
