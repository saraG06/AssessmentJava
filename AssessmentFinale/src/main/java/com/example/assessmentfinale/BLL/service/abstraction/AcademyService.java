package com.example.assessmentfinale.BLL.service.abstraction;

import com.example.assessmentfinale.BLL.dto.request.AcademyRequestDTO;
import com.example.assessmentfinale.BLL.dto.response.AcademyResponseDTO;
import com.example.assessmentfinale.DAL.entities.Academy;

import java.util.List;

public interface AcademyService {

    void saveAcademy (AcademyRequestDTO academyRequestDTO); //è il punto 3?

    List<AcademyResponseDTO> getAllAcademy();

    AcademyResponseDTO getAcademyByName(String nome);

}
