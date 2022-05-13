package it.unikey.assessmentproject.BLL.service.abstraction;

import it.unikey.assessmentproject.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;
import it.unikey.assessmentproject.DAL.entity.Academy;

import java.time.LocalDate;
import java.util.List;

public interface AcademyService {

    void saveAcademy(AcademyRequestDTO academyRequestDTO);

    AcademyResponseDTO getAcademyById(Long id) throws EntityNotFoundException;

    void deleteAcademyById(Long id) throws EntityNotFoundException;

    List<AcademyResponseDTO> getAllAcademy();

    List<AcademyResponseDTO> getAllAcademyByNomeContaining(String nome);

    List<AcademyResponseDTO> getAcademyByModuloListContainingModulo(ModuloRequestDTO moduloRequestDTO);

    List<AcademyResponseDTO> getAcademyByInizio(LocalDate inizio);

    List<AcademyResponseDTO> getAcademyByFine(LocalDate fine);

    AcademyResponseDTO getAcademyInfo(Long id);

}
