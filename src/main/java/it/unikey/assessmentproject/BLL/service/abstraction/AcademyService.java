package it.unikey.assessmentproject.BLL.service.abstraction;

import it.unikey.assessmentproject.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;

import java.util.List;

public interface AcademyService {

    void saveAcademy(AcademyRequestDTO academyRequestDTO);

    AcademyResponseDTO getAcademyById(Long id) throws EntityNotFoundException;

    void deleteAcademyById(Long id) throws EntityNotFoundException;

    List<AcademyResponseDTO> getAllAcademy();

}
