package it.unikey.assessmentjavaleonardopaolini.DAL.Repository;

import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Academy;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy,Long> {

    Academy getAcademyByNome(String nome);

    @Query("SELECT a FROM Academy a INNER JOIN Modulo m ON a.id=m.academy.id WHERE m.nome LIKE CONCAT('%',:modulo,'%')")
    List<Academy> getAcademyByModulo(@Param("modulo") String modulo);

    //@Query( value = "SELECT * FROM academy a INNER JOIN modulo m ON a.id=m.academy INNER JOIN docente d ON m.docente=d.id  WHERE a.id =:id",nativeQuery = true)
    @Query("SELECT m FROM Academy  a INNER JOIN Modulo m ON a.id = m.academy.id INNER JOIN Docente d ON m.docente.id = d.id WHERE a.id=:id")
    Modulo getAcademyInfo(@Param("id") Long id);

    @Query("SELECT a FROM Academy a WHERE a.datainizio>=:data")
    List<Academy> getAcademyStartData(@Param("data") LocalDate data);




}
