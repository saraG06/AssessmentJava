package it.unikey.assestmentjava.DAL.repository;

import it.unikey.assestmentjava.DAL.entity.Discente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscenteRepository extends JpaRepository<Discente, Long> {
}
