package it.unikey.assessmentjavaleonardopaolini.DAL.Repository;

import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends JpaRepository<Academy,Long> {

    Academy getAcademyByNome(String nome);
}
