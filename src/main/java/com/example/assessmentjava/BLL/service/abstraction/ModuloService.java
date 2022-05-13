package com.example.assessmentjava.BLL.service.abstraction;

import com.example.assessmentjava.BLL.dto.request.ModuloRequestDto;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDto;
import com.example.assessmentjava.BLL.dto.response.ModuloResponseDto;

import java.util.List;

public interface ModuloService {

    void saveModulo (ModuloRequestDto moduloRequestDto);
    ModuloResponseDto findById (Long id);
    void deleteModuloById (Long id);
    List<ModuloResponseDto> findAllModulo();


}
