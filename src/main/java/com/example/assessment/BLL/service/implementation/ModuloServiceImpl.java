package com.example.assessment.BLL.service.implementation;

import com.example.assessment.BLL.dto.request.ModuloRequestDTO;
import com.example.assessment.BLL.dto.response.ModuloResponseDTO;
import com.example.assessment.BLL.mapper.implementation.ModuloRequestMapper;
import com.example.assessment.BLL.mapper.implementation.ModuloResponseMapper;
import com.example.assessment.BLL.service.abstraction.ModuloService;
import com.example.assessment.DAL.entity.Modulo;
import com.example.assessment.DAL.repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModuloServiceImpl implements ModuloService {

    private final ModuloRepository moduloRepository;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;

    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) {
        Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
        moduloRepository.save(m);
    }

    @Override
    public ModuloResponseDTO findModuloById(Long id) throws NullPointerException {
        Modulo m = moduloRepository.getById(id);

        if (id != null) {
            return moduloResponseMapper.asDTO(m);
        } else throw new NullPointerException();
    }
}
