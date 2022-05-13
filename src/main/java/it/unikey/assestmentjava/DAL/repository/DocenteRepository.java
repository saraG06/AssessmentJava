package it.unikey.assestmentjava.DAL.repository;

import it.unikey.assestmentjava.DAL.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
}
