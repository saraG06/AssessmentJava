package it.unikey.assesmentfedericodc.DAL.repository;

import it.unikey.assesmentfedericodc.DAL.entity.Accademy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccademyRepository extends JpaRepository<Accademy,Long> {
}
