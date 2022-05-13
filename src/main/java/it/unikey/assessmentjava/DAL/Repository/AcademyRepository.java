package it.unikey.assessmentjava.DAL.Repository;

import it.unikey.assessmentjava.DAL.Entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends JpaRepository<Academy,Long> {
}
