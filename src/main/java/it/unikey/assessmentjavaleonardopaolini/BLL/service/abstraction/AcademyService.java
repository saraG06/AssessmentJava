package it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.AcademyResponseDTO;

import java.util.List;

public interface AcademyService {

    void saveAcademy(AcademyRequestDTO academyRequestDTO);

    List<AcademyResponseDTO> findAllAcademy();
}
