package com.example.assessmentjava.BLL.service.abstraction;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDto;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDto;
import com.example.assessmentjava.DAL.Entity.Academy;

import java.util.List;

public interface AcademyService {
    void saveAcademy (AcademyRequestDto academyRequestDto);
    AcademyResponseDto findById (Long id);
    void deleteAcademyById (Long id);

    List<AcademyResponseDto> findAllAcademy();

}
