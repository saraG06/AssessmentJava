package it.unikey.BLL.service.abstraction;

import it.unikey.BLL.dto.request.AcademyRequestDTO;
import it.unikey.BLL.dto.response.AcademyResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;

import java.util.List;

public interface AcademyService {
    void saveAcademy(AcademyRequestDTO academyRequestDTO);
    AcademyResponseDTO findById(Long id) throws IdNotFoundException;
    void deleteAcademy(Long id) throws IdNotFoundException;
    List<AcademyResponseDTO> findAllAcademy();
}
