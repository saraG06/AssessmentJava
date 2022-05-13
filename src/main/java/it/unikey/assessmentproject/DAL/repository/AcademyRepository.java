package it.unikey.assessmentproject.DAL.repository;

import it.unikey.assessmentproject.DAL.entity.Academy;
import it.unikey.assessmentproject.DAL.entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository <Academy, Long> {

    @Query(value = "SELECT p FROM Academy p WHERE :nome in p.nome")
    List<Academy> getAcademyByNomeContaining(@Param("nome") String nome);

    @Query(value = "SELECT p FROM Academy p WHERE :modulo in p.moduloList")
    List<Academy> getAcademyByModuloListContainingModulo(@Param("modulo") Modulo modulo);

}
