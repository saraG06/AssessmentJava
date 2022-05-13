package it.unikey.assestmentjava.BLL.service.abstraction;

import it.unikey.assestmentjava.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assestmentjava.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assestmentjava.DAL.entity.Academy;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AcademyService {

    void save(AcademyRequestDTO academyRequestDTO);

    AcademyResponseDTO findById(Long id);

    void deleteById(Long id);

    List<AcademyResponseDTO> findAll();

    List<AcademyResponseDTO> getAcademyByNome(String nome);

    List<AcademyResponseDTO> getAcademyByModulo(ModuloRequestDTO moduloRequestDTO);
    AcademyResponseDTO getAcademyInfo(String nome);
    List<AcademyResponseDTO> getAcademyByDataInizio(LocalDate datainizio);

    List<AcademyResponseDTO> getAcademyByDataFine(LocalDate datafine);

    List<AcademyResponseDTO> getAcademyByIntervalloDate(LocalDate inizio, LocalDate fine);

}
