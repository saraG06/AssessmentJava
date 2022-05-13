package it.unikey.assessmentjava.BLL.service.abstraction;

import it.unikey.assessmentjava.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;

import java.util.List;

public interface AcademyService {

    void saveAcademy(AcademyRequestDTO academyRequestDTO);

    List<AcademyResponseDTO> findAllAcademy();

    AcademyResponseDTO findAcademyById(Long id);

    void deleteAcademyById(Long id);
}
