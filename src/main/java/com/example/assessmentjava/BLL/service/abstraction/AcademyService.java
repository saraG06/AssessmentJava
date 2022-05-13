package com.example.assessmentjava.BLL.service.abstraction;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDto;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDto;
import com.example.assessmentjava.DAL.Entity.Academy;
import com.example.assessmentjava.DAL.Entity.Modulo;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AcademyService {
    void saveAcademy (AcademyRequestDto academyRequestDto);
    AcademyResponseDto findById (Long id);
    void deleteAcademyById (Long id);

    List<AcademyResponseDto> findAllAcademy();
    List<AcademyResponseDto> findAcademyByNomeIgnoreCase (String nome);
    List<AcademyResponseDto> findByModulo(Modulo modulo);
    AcademyResponseDto findInfo(Long id);

    List<AcademyResponseDto> dataInizio(LocalDate date);

    List<AcademyResponseDto> dataFine(LocalDate date);

}
