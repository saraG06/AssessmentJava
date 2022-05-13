package it.unikey.testfinale.BLL.service.abstraction;

import it.unikey.testfinale.BLL.mapper.dto.request.ModuloRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.ModuloResponseDTO;

import java.util.List;

public interface ModuloService {

    void saveModulo(ModuloRequestDTO moduloRequestDTO);

    ModuloResponseDTO findById(Long id);

    void deleteById(Long id);

    List<ModuloResponseDTO> findAllModulo();
}
