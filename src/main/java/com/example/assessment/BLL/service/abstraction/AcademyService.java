package com.example.assessment.BLL.service.abstraction;

import com.example.assessment.BLL.dto.request.AcademyRequestDTO;
import com.example.assessment.BLL.dto.response.AcademyResponseDTO;
import com.example.assessment.DAL.entity.Academy;

public interface AcademyService {

    void saveAcademy(AcademyRequestDTO academyRequestDTO);

    AcademyResponseDTO findAcademyById(Long id);
}
