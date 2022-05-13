package it.unikey.assessmentproject.BLL.service.abstraction;

import it.unikey.assessmentproject.BLL.DTO.request.ModuloRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.ModuloResponseDTO;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;

import java.util.List;

public interface ModuloService {

    void saveModulo(ModuloRequestDTO moduloRequestDTO);

    ModuloResponseDTO getModuloById(Long id) throws EntityNotFoundException;

    void deleteModuloById(Long id) throws EntityNotFoundException;

    List<ModuloResponseDTO> getAllModulo();

}
