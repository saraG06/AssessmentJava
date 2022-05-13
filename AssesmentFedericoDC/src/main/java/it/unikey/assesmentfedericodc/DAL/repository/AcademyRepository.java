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

    //trvova tutte le academy il cui nome comprenda la stringa passata a paramentro,
    // es AccademyJavaMarzo ritorna se passo nome="Java"
    @Query(value = "SELECT * FROM Academy a  WHERE a.nome LIKE '%'+:nome+'%' ", nativeQuery = true)
    List<Academy> findByNome(@Param("nome") String nome);

    //tutte le accademy che abbiano un modulo il cui nome comprenda la stringa passata a paramentro
    @Query(value = "SELECT DISTINCT a FROM Academy a, Modulo m  " +
            "WHERE m.academy= a AND m.nome LIKE '%'+:nome+'%' " )
    List<Academy> findByModulo(@Param("nome") String nomeModulo);

    //tutte le academy la cui data di inizio dia successiva a quella passata a parametro
    @Query(value = "SELECT * FROM Academy a WHERE  a.data_inizio > :data ", nativeQuery = true)
    List<Academy> findByDataIniziaDopo(@Param("data") LocalDate data);

    //tutte le academy la cui data di fine dia precedente a quella passata a parametro
    @Query(value = "SELECT * FROM Academy a WHERE  a.data_fine < :data ", nativeQuery = true)
    List<Academy> findByDataFiniscePrima(@Param("data") LocalDate data);

    //tutte le academy la cui data di inizio e fine siano comprese tra quelle passata a parametro
    @Query(value = "SELECT * FROM Academy a WHERE a.data_inizio > :dataMin AND a.data_fine < :dataMax ", nativeQuery = true)
    List<Academy> findByDataCompresa(@Param("dataMin") LocalDate dataMin,@Param("dataMax") LocalDate dataMax);

}
