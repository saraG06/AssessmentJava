package it.unikey.assessmentjava.DAL.repository;

import it.unikey.assessmentjava.DAL.entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {
}
