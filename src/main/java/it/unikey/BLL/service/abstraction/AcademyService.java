package it.unikey.BLL.service.abstraction;

import it.unikey.BLL.dto.request.AcademyRequestDTO;
import it.unikey.BLL.dto.response.AcademyResponseDTO;
import it.unikey.BLL.exception.DateNotValidException;
import it.unikey.BLL.exception.IdNotFoundException;
import it.unikey.BLL.exception.NameNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface AcademyService {
    void saveAcademy(AcademyRequestDTO academyRequestDTO);
    AcademyResponseDTO findById(Long id) throws IdNotFoundException;
    void deleteAcademy(Long id) throws IdNotFoundException;
    List<AcademyResponseDTO> findAllAcademy();
    List<AcademyResponseDTO> findByNome(String nome) throws NameNotFoundException;
    List<AcademyResponseDTO> findByModulo(String modulo) throws NameNotFoundException;
    List<AcademyResponseDTO> findByDataDopo(LocalDate data) throws DateNotValidException;
    List<AcademyResponseDTO> findByDataPrima(LocalDate data) throws DateNotValidException;

    List<AcademyResponseDTO> findByDataCompresa(LocalDate data1, LocalDate data2) throws DateNotValidException;
}
