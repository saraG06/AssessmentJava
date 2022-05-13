package it.unikey.testfinale.BLL.service.abstraction;

import it.unikey.testfinale.BLL.Exception.AlreadyExistsException;
import it.unikey.testfinale.BLL.Exception.ConflictBetweenAttributesException;
import it.unikey.testfinale.BLL.mapper.dto.request.AcademyRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.request.ModuloRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.AcademyResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface AcademyService {

    void saveAcademy(AcademyRequestDTO academyRequestDTO) throws ConflictBetweenAttributesException, AlreadyExistsException;

    AcademyResponseDTO findById(Long id);

    void deleteById(Long id);

    List<AcademyResponseDTO> findAllAcademy();

    List<AcademyResponseDTO> findByNome(String nome);

    List<AcademyResponseDTO> findByModulo(ModuloRequestDTO moduloRequestDTO);

    List<AcademyResponseDTO> findDetails(Long id);

    List<AcademyResponseDTO> findByDataInizio(LocalDate dataInizio);

    List<AcademyResponseDTO> findByDataFine(LocalDate dataFine);

    List<AcademyResponseDTO> findByData(LocalDate dataInizio, LocalDate dataFine);
}
