package it.unikey.assessmentjava.BLL.service.astratti;

import it.unikey.assessmentjava.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.ModuloResponseDTO;

import java.util.List;

public interface ModuloService {
    void saveModulo(ModuloRequestDTO moduloRequestDTO);
    ModuloResponseDTO findById(Long id);
    void deleteById(Long id);
    List<ModuloResponseDTO> findAllModuli();
}
