package it.unikey.assessmentjava.BLL.Service.Abstraction;

import it.unikey.assessmentjava.BLL.Dto.Request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;

import java.util.List;

public interface AcademyService {

    void saveAcademy(AcademyRequestDTO academyRequestDTO);

    List<AcademyResponseDTO> findAll();

    List<AcademyResponseDTO> findAllByNomeContainingIgnoreCase(String nome);

    List<AcademyResponseDTO> findAllByModulo(String modulo);

    List<AcademyResponseDTO> findAllWithDetails();
}
