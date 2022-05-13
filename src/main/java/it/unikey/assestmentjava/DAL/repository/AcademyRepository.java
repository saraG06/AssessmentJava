package it.unikey.assestmentjava.DAL.repository;

import it.unikey.assestmentjava.DAL.entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {
}
