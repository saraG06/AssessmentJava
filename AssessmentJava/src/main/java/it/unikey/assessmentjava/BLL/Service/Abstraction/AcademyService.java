package it.unikey.assessmentjava.BLL.Service.Abstraction;

import it.unikey.assessmentjava.BLL.Dto.Request.AcademyRequestDTO;
import it.unikey.assessmentjava.BLL.Dto.Response.AcademyResponseDTO;
import it.unikey.assessmentjava.DAL.Entity.Academy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AcademyService {

    void saveAcademy(AcademyRequestDTO academyRequestDTO);

    List<AcademyResponseDTO> findAll();

    List<AcademyResponseDTO> findAllByNomeContainingIgnoreCase(String nome);

    List<AcademyResponseDTO> findAllByModulo(String modulo);

    AcademyResponseDTO findByIdWithDetails(Long id);

    List<AcademyResponseDTO> findAcademyStartAfterData(LocalDate data);

    List<AcademyResponseDTO> findAcademyEndBeforeData(LocalDate data);

    List<AcademyResponseDTO> findAllByDataBetweenTwoDates(LocalDate data1,LocalDate data2);
}
