package it.unikey.assesmentfedericodc.DAL.repository;

import it.unikey.assesmentfedericodc.DAL.entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo,Long> {
}
