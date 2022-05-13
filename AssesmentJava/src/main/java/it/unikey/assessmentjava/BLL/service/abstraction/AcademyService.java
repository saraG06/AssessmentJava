package it.unikey.assessmentjava.BLL.service.abstraction;

import it.unikey.assessmentjava.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.AcademyResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface AcademyService {

    void saveAcademy(AcademyRequestDTO academyRequestDTO);

    List<AcademyResponseDTO> findAllAcademy();

    AcademyResponseDTO findAcademyById(Long id);

    void deleteAcademyById(Long id);

    List<AcademyResponseDTO> academyConNome(String nome);

    List<AcademyResponseDTO> academyNomeModulo(String nomemodulo);

    AcademyResponseDTO academyDetails(Long id);

    List<AcademyResponseDTO> startDate(LocalDate date);

    List<AcademyResponseDTO> endDate(LocalDate date);

    List<AcademyResponseDTO> betweenDate(LocalDate dateone, LocalDate datetwo);
}
