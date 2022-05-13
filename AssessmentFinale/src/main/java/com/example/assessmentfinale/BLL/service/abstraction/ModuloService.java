package com.example.assessmentfinale.BLL.service.abstraction;

import com.example.assessmentfinale.BLL.dto.request.ModuloRequestDTO;
import com.example.assessmentfinale.BLL.dto.response.ModuloResponseDTO;

public interface ModuloService {

    void saveModulo (ModuloRequestDTO moduloRequestDTO);

    ModuloResponseDTO getById(Long id);
}
