package com.example.assessmentjava.DAL.Repository;

import com.example.assessmentjava.DAL.Entity.Academy;
import com.example.assessmentjava.DAL.Entity.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {

    List<Academy> findAcademyByNomeIgnoreCase (String nome);

    @Query(value= "SELECT * " +
            "FROM Academy a, Discente d, Modulo m " +
            "WHERE a.id= m.academy_id AND a.id= d.academy_id " +
            "AND m.id= :modulo.id", nativeQuery = true)
    List<Academy> findByModulo(@Param("modulo") Modulo modulo);


    //@Query(value = "SELECT a FROM Academy a JOIN Modulo m ON m.academy.id = a.id JOIN Discente d ON d.academy.id = a.id WHERE a.id = m.academy.id AND m.id = :id")
    Academy academyDetails(Long id);

    //Visualizza dettagli Academy
    @Query(value = "SELECT a FROM Academy a JOIN Modulo  m ON m.academy.id = a.id JOIN Discente d ON d.academy.id = a.id WHERE a.id = :id")
    Academy findInfo(Long id);

    @Query(value = "SELECT a FROM Academy a WHERE a.dataInizio > :date")
    List<Academy> dataInizio(@Param("date") LocalDate date);

    @Query(value = "SELECT a FROM Academy a WHERE a.dataFine < :date")
    List<Academy> dataFine(@Param("date") LocalDate date);
}
