package it.unikey.assesmentfedericodc.DAL.repository;

import it.unikey.assesmentfedericodc.DAL.entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy,Long> {

    //funzionera?
    @Query(value = "SELECT * FROM Academy a  WHERE a.nome LIKE '%'+:nome+'%' ", nativeQuery = true)
    List<Academy> findByNome(@Param("nome") String nome);

    @Query(value = "SELECT  a FROM Academy a, Modulo m  " +
            "WHERE m.academy= a AND m.nome LIKE '%'+:nome+'%' ")
    List<Academy> findByModulo(@Param("nome") String nomeModulo);

    @Query(value = "SELECT * FROM Academy a WHERE  a.data_inizio > :data ", nativeQuery = true)
    List<Academy> findByDataIniziaDopo(@Param("data") LocalDate data);

    @Query(value = "SELECT * FROM Academy a WHERE  a.data_fine < :data ", nativeQuery = true)
    List<Academy> findByDataFiniscePrima(@Param("data") LocalDate data);

    @Query(value = "SELECT * FROM Academy a WHERE a.data_inizio > :dataMin AND a.data_fine < :dataMax ", nativeQuery = true)
    List<Academy> findByDataCompresa(@Param("dataMin") LocalDate dataMin,@Param("dataMax") LocalDate dataMax);

}
