package com.example.assessmentfinale.DAL.repository;

import com.example.assessmentfinale.BLL.dto.request.AcademyRequestDTO;
import com.example.assessmentfinale.BLL.dto.response.AcademyResponseDTO;
import com.example.assessmentfinale.DAL.entities.Academy;
import com.example.assessmentfinale.DAL.entities.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {

    @Query ("SELECT a FROM Academy a")
    List<AcademyResponseDTO> getAllAcademy();

    @Query ("SELECT a FROM Academy a  WHERE a.nome=:nome")
    Academy getAcademyByName(@Param("nome") String nome);

    @Query(value = "SELECT a FROM Academy a WHERE a.moduli=: nome")
    Academy getAcademyWithModulo (@Param("modulo") String nome);

    Academy getAcademyByModuliIsContaining (String nome);



}
