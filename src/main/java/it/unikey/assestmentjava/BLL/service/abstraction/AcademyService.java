package it.unikey.assestmentjava.BLL.service.abstraction;

import it.unikey.assestmentjava.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.AcademyResponseDTO;

import java.util.List;

public interface AcademyService {

    void save(AcademyRequestDTO academyRequestDTO);

    AcademyResponseDTO findById(Long id);

    void deleteById(Long id);

    List<AcademyResponseDTO> findAll();
}
