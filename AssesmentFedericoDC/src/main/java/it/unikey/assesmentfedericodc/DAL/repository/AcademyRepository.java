package it.unikey.assesmentfedericodc.DAL.repository;

import it.unikey.assesmentfedericodc.DAL.entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy,Long> {

    //funzionera?
    @Query(value = "SELECT * FROM Academy a  WHERE a.nome LIKE '%'+:nome+'%' ", nativeQuery = true)
    List<Academy> findByNome(@Param("nome") String nome);

    @Query(value = "SELECT  a FROM Academy a, Modulo m  " +
            "WHERE m.academy= a AND m.nome LIKE '%'+:nome+'%' ")
    List<Academy> findByModulo(@Param("nome") String nomeModulo);

}
