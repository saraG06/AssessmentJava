package it.unikey.assestmentjava.BLL.service.abstraction;

import it.unikey.assestmentjava.BLL.dto.request.PersonaRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.PersonaResponseDTO;

import java.util.List;

public interface PersonaService {

    void save(PersonaRequestDTO personaRequestDTO);

    PersonaResponseDTO findById(Long id);

    void deleteById(Long id);

    List<PersonaResponseDTO> findAll();
}
