package it.unikey.assessmentproject.DAL.repository;

import it.unikey.assessmentproject.DAL.entity.Academy;
import it.unikey.assessmentproject.DAL.entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository <Academy, Long> {

    @Query(value = "SELECT * FROM academy a  WHERE a.nome LIKE '%:nome%'", nativeQuery = true)
    List<Academy> getAcademyByNomeContaining(@Param("nome") String nome);

    @Query(value = "SELECT p FROM Academy p WHERE :modulo in p.moduloList")
    List<Academy> getAcademyByModuloListContainingModulo(@Param("modulo") Modulo modulo);

    @Query(value = "SELECT p FROM Academy p WHERE p.inizio = :data")
    List<Academy> getAcademyByDataInizio(@Param("data") LocalDate inizio);

    @Query(value = "SELECT p FROM Academy p WHERE p.fine = :data")
    List<Academy> getAcademyByDataFine(@Param("data") LocalDate fine);

    @Query(value = "SELECT a.nome, m.inizioModulo, m.fineModulo, m.nome, d.nome, d.cognome" +
            "       FROM Academy a INNER JOIN Modulo m ON m.academy = a " +
            "                      INNER JOIN Discente d ON d.academy = a" +
            "       WHERE a.nome = :id")
    Academy getAcademyInfo(@Param("id") Long id);

}
