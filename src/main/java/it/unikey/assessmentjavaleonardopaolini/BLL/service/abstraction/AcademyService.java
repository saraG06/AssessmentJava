package it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.ModuloResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface AcademyService {

    void saveAcademy(AcademyRequestDTO academyRequestDTO);

    AcademyResponseDTO findAcademyPerNome(String nome);

    List<AcademyResponseDTO> findAllAcademy();

    List<AcademyResponseDTO> findAllAcademyByModulo(String modulo);

    ModuloResponseDTO findAcademyInfo(Long id);

    List<AcademyResponseDTO> findAcademyStartData(LocalDate data);


}
