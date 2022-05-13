package it.unikey.assessmentjava.DAL.repository;

import it.unikey.assessmentjava.DAL.entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends JpaRepository<Academy,Long> {
}
