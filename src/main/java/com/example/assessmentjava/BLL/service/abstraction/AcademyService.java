package com.example.assessmentjava.BLL.service.abstraction;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDTO;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDTO;

import java.util.List;

public interface AcademyService {
    void saveAcademy (AcademyRequestDTO academyRequestDTO);
    AcademyResponseDTO findByid(Long id) throws NullPointerException;
    void deleteByid(Long id) throws NullPointerException;
    List<AcademyResponseDTO> findAllAcademy();
}
