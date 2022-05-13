package com.example.assessmentfinale.BLL.service.impl;

import com.example.assessmentfinale.BLL.dto.request.ModuloRequestDTO;
import com.example.assessmentfinale.BLL.dto.response.ModuloResponseDTO;
import com.example.assessmentfinale.BLL.mapper.impl.request.ModuloRequestMapper;
import com.example.assessmentfinale.BLL.mapper.impl.response.ModuloResponseMapper;
import com.example.assessmentfinale.BLL.service.abstraction.ModuloService;
import com.example.assessmentfinale.DAL.entities.Modulo;
import com.example.assessmentfinale.DAL.repository.ModuloRepository;

public class ModuloServiceImpl implements ModuloService {

    public ModuloRepository moduloRepository;
    public ModuloRequestMapper moduloRequestMapper;
    public ModuloResponseMapper moduloResponseMapper;

    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) {
        Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
        moduloRepository.save(m);
    }

    @Override
    public ModuloResponseDTO getById(Long id) {
        Modulo d = moduloRepository.getById(id);

        if (id != null) {
            return moduloResponseMapper.asDTO(d);
        } else throw new NullPointerException("Entity not found");
    }
}
