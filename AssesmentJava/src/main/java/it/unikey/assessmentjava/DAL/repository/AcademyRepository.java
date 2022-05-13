package it.unikey.assessmentjava.DAL.repository;

import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentjava.DAL.entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy,Long> {

    @Query(value = "SELECT a FROM Academy a WHERE a.nome LIKE %:nome% ")
    List<Academy> academyConNome(@Param("nome")String nome);

    @Query(value = "SELECT DISTINCT a FROM Academy a JOIN Modulo m ON m.academy.id = a.id WHERE m.nome LIKE %:nomemodulo%")
    List<Academy> academyNomeModulo(@Param("nomemodulo") String nomemodulo);

    @Query(value = "SELECT a FROM Academy a JOIN Modulo  m ON m.academy.id = a.id JOIN Docente d ON m.docente.id = d.id JOIN Discente di ON di.academy.id = a.id WHERE a.id = :id")
    Academy academyDetails(Long id);

    @Query(value = "SELECT a FROM Academy a WHERE a.datadiInizio > :date")
    List<Academy> startDate(@Param("date") LocalDate date);

    @Query(value = "SELECT a FROM Academy a WHERE a.datadiFine < :date")
    List<Academy> endDate(@Param("date") LocalDate date);

    @Query(value = "SELECT a FROM Academy a WHERE a.datadiInizio > :dateone AND a.datadiFine < :datetwo")
    List<Academy> betweenDate(@Param("dateone") LocalDate dateone, @Param("datetwo") LocalDate datetwo);

}
