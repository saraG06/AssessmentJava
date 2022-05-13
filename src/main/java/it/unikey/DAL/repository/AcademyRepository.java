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

    @Query(value = "SELECT a  FROM academy a, discente di, docente do, modulo m WHERE a.id= m.academy_id AND a.id= di.academy_id AND do.id= m.docente_id  AND m.id= :modulo.id ", nativeQuery = true)
    List<Academy> findByModulo(@Param("modulo") Modulo modulo);
}
