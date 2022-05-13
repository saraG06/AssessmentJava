package it.unikey.assessmentjava.BLL.service.abstraction;

import it.unikey.assessmentjava.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.ModuloResponseDTO;

import java.util.List;

public interface ModuloService {

    void saveModulo(ModuloRequestDTO moduloRequestDTO);

    List<ModuloResponseDTO> findAllModulo();

    ModuloResponseDTO findModuloById(Long id);

    void deleteModuloById(Long id);
}
