package com.example.assessment.BLL.service.abstraction;

import com.example.assessment.BLL.dto.request.ModuloRequestDTO;
import com.example.assessment.BLL.dto.response.ModuloResponseDTO;

public interface ModuloService {

    void saveModulo(ModuloRequestDTO moduloRequestDTO);

    ModuloResponseDTO findModuloById(Long id);
}
