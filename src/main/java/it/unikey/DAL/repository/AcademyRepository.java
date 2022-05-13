package it.unikey.DAL.repository;

import it.unikey.DAL.entity.Academy;
import it.unikey.DAL.entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {
    @Query("select a from Academy a where a.nome like %:nome%")
    List<Academy> findByName (@Param("nome") String nome);

    @Query("SELECT  a FROM Academy a, Modulo m WHERE m.academy.id = a.id AND m.nome LIKE %:nome% ")
    List<Academy> findByModulo(@Param("nome") String nome);
}
