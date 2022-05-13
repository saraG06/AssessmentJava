package it.unikey.assestmentjava.DAL.repository;

import it.unikey.assestmentjava.DAL.entity.Academy;
import it.unikey.assestmentjava.DAL.entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {

    @Query(value = "SELECT * FROM academy a  WHERE a.nome LIKE '%:nome%'", nativeQuery = true)
    List<Academy> getAcademyByNome(@Param("nome") String nome);
    @Query(value = "SELECT a FROM Academy a WHERE :modulo in a.moduli")
    List<Academy> getAcademyByModulo(@Param("modulo") Modulo modulo);

    @Query(value = "SELECT a.nome, a.datainizio, a.datafine, m.nome, m.argomenti, d.persona.nome, d.persona.cognome" +
            "       FROM Academy a INNER JOIN Modulo m ON m.academy = a " +
            "                      INNER JOIN Discente d ON d.academy = a" +
            "       WHERE a.nome = :nome")
    Academy getAcademyInfo(@Param("nome") String nome);
    @Query(value = "SELECT a FROM Academy a WHERE a.datainizio >= :datainizio")
    List<Academy> getAcademyByDataInizio(@Param("datainizio") LocalDate inizio);
    @Query(value = "SELECT a FROM Academy a WHERE a.datafine <= :datafine")
    List<Academy> getAcademyByDataFine(@Param("datafine") LocalDate fine);

    @Query(value = "SELECT a FROM Academy a WHERE a.datainizio >= :datainizio AND a.datafine <= :datafine")
    List<Academy> getAcademyByIntervalloDate(@Param("datainizio") LocalDate inizio, @Param("datafine") LocalDate fine);

}
