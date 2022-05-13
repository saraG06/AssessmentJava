package it.unikey.assessmentjava.DAL.Repository;

import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {

    List<Academy> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

    @Query("select distinct a from Academy a, Modulo m where m.nome like %:modulo%")
    List<Academy> findAllByModulo(@Param("modulo") String modulo);

    @Query("select a from Academy a where a.id = :id")
    Academy findAcademyByIdWithDetails(@Param("id") Long id);

    @Query("select a from Academy a where a.dataInizio > :data")
    List<Academy> findAcademyStartAfterData(@Param("data") LocalDate data);
    @Query("select a from Academy a where a.dataFine < :data")
    List<Academy> findAcademyEndBeforeData(@Param("data") LocalDate data);

    @Query("select a from Academy a where a.dataInizio between :data1 and :data2 and a.dataFine between :data1 and :data2")
    List<Academy> findAllByDataInizioBetweenTwoDates(@Param("data1") LocalDate data1,@Param("data2") LocalDate data2);
}
