package it.unikey.assessmentproject.BLL.service.abstraction;

import it.unikey.assessmentproject.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.ModuloResponseDTO;

import java.util.List;

public interface ModuloService {

    void saveModulo(ModuloRequestDTO moduloRequestDTO);

    ModuloResponseDTO getModuloById(Long id);

    void deleteModuloById(Long id);

    List<ModuloResponseDTO> getAllModulo();

}
