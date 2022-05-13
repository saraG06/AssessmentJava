package it.unikey.testfinale.DAL.Repository;

import it.unikey.testfinale.DAL.Entity.Academy;
import it.unikey.testfinale.DAL.Entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {

    //ricercare la/e academy filtrando per nome
    @Query(value= "SELECT * " +
            "FROM academy a " +
            "WHERE a.id= m.academy_id AND a.id= di.academy_id AND do.id= m.docente_id " +
            "AND a.nome LIKE '%:nome%'", nativeQuery = true)
    List<Academy> findByNome(@Param("nome") String nome);

    //filtrare le academy per moduli
    @Query(value= "SELECT * " +
            "FROM academy a, discente di, docente do, modulo m " +
            "WHERE a.id= m.academy_id AND a.id= di.academy_id AND do.id= m.docente_id " +
            "AND m.id= :modulo.id", nativeQuery = true)
    List<Academy> findByModulo(@Param("modulo") Modulo modulo);

    //visualizzare il dettaglio dell'academy (info academy + info moduli + info discenti)
    @Query(value= "SELECT * " +
            "FROM academy a, discente di, docente do, modulo m " +
            "WHERE a.id= m.academy_id AND a.id= di.academy_id AND do.id= m.docente_id " +
            "AND a.id= :id", nativeQuery = true)
    List<Academy> findDetails(@Param("id") Long id);

    //filtrare la lista delle academy per dataInizio
    @Query(value= "SELECT * " +
            "FROM academy a, discente di, docente do, modulo m " +
            "WHERE a.id= m.academy_id AND a.id= di.academy_id AND do.id= m.docente_id " +
            "AND a.dataInizio >= :dataInizio", nativeQuery = true)
    List<Academy> findByDataInizio(@Param("dataInizio") LocalDate dataInizio);

    //filtrare la lista delle academy per dataFine
    @Query(value= "SELECT * " +
            "FROM academy a, discente di, docente do, modulo m " +
            "WHERE a.id= m.academy_id AND a.id= di.academy_id AND do.id= m.docente_id " +
            "AND a.dataFine <= :dataFine", nativeQuery = true)
    List<Academy> findByDataFine(@Param("dataFine") LocalDate dataFine);

    //filtrare la lista delle academy per dataFine
    @Query(value= "SELECT * " +
            "FROM academy a, discente di, docente do, modulo m " +
            "WHERE a.id= m.academy_id AND a.id= di.academy_id AND do.id= m.docente_id " +
            "AND a.dataInizio >= :dataInizio AND a.dataFine <= :dataFine", nativeQuery = true)
    List<Academy> findByData(@Param("dataInizio") LocalDate dataInizio, @Param("dataFine") LocalDate dataFine);
}
