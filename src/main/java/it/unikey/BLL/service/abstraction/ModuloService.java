package it.unikey.BLL.service.abstraction;

import it.unikey.BLL.dto.request.ModuloRequestDTO;
import it.unikey.BLL.dto.response.ModuloResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;

import java.util.List;

public interface ModuloService {
    void saveModulo(ModuloRequestDTO moduloRequestDTO);
    ModuloResponseDTO findById(Long id) throws IdNotFoundException;
    void deleteModulo(Long id) throws IdNotFoundException;
    List<ModuloResponseDTO> findAllModulo();
}
