package it.unikey.assessmentjava.BLL.service.astratti;

import it.unikey.assessmentjava.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.AcademyResponseDTO;

import java.util.List;

public interface AcademyService {
    void saveAcademy(AcademyRequestDTO academyRequestDTO);
    AcademyResponseDTO findById(Long id);
    void deleteById(Long id);
    List<AcademyResponseDTO> findAllAcademy();
    List<AcademyResponseDTO> findByNome(String nome);
    List<AcademyResponseDTO> findByModulo(String nomeModulo) ;
}
