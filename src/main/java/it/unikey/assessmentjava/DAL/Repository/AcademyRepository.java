package it.unikey.assessmentjava.DAL.Repository;

import it.unikey.assessmentjava.DAL.Entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy,Long> {

    @Query(value = "SELECT a FROM Academy a")
    List<Academy> findAllAcademy(@Param("id") Long id);

    @Query(value = "SELECT a FROM Accademy a  WHERE a.nome LIKE '%:nome%' ", nativeQuery = true)
    List<Academy> findByNome(@Param("nome") String nome);

    @Query(value = "SELECT DISTINCT a FROM Accademy a, Modulo m WHERE m.academy = academy AND m.nome LIKE '%:nomeModulo%' ", nativeQuery = true)
    List<Academy> findByModulo(@Param("nome") String nomeModulo);

    @Query(value = "SELECT a FROM Academy a JOIN Modulo  m ON m.academymodulo.id_academy = a.id_academy " +
            "JOIN Docente d ON m.docente.id_docente = d.id_docente " +
            "JOIN Discenti di ON di.academy.id_academy = a.id_academy " +
            "WHERE a.id_academy = :id")
    Academy Dettagliacademy(Long id);
}
