package it.unikey.assessmentjava.DAL.Repository;

import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {

    List<Academy> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

    @Query("select distinct a from Academy a, Modulo m where m.nome like %:modulo%")
    List<Academy> findAllByModulo(@Param("modulo") String modulo);

    @Query("select distinct a from Academy a")
    List<Academy> findAllWithDetails();
}
