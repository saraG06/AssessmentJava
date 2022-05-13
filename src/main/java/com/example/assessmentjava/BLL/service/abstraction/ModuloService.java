package com.example.assessmentjava.BLL.service.abstraction;

import com.example.assessmentjava.BLL.dto.request.ModuloRequestDTO;
import com.example.assessmentjava.BLL.dto.response.ModuloResponseDTO;

import java.util.List;

public interface ModuloService {
    void saveModulo (ModuloRequestDTO moduloRequestDTO);
    ModuloResponseDTO findByid(Long id) throws NullPointerException;
    void deleteByid(Long id) throws NullPointerException;
    List<ModuloResponseDTO> findAllModuli();
}
