package com.example.assessmentjava.BLL.service.impl;

import com.example.assessmentjava.BLL.dto.request.ModuloRequestDTO;
import com.example.assessmentjava.BLL.dto.response.ModuloResponseDTO;
import com.example.assessmentjava.BLL.mapper.implementation.*;
import com.example.assessmentjava.BLL.service.abstraction.ModuloService;
import com.example.assessmentjava.DAL.Entity.Academy;
import com.example.assessmentjava.DAL.Entity.Modulo;
import com.example.assessmentjava.DAL.Repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuloServiceImpl implements ModuloService {

    private final ModuloRepository moduloRepository;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;
    private final AcademyRequestMapper academyRequestMapper;
    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) {
        Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
        Academy academy= academyRequestMapper.asEntity(moduloRequestDTO.getAcademyRequestDTO());

        m.setAcademy(academy);

        moduloRepository.save(m);
    }

    @Override
    public ModuloResponseDTO findByid(Long id) throws NullPointerException {
        Modulo m = moduloRepository.getById(id);
        if(m != null)
            return moduloResponseMapper.asDTO(m);
        else
            throw new NullPointerException("non presente");
    }

    @Override
    public void deleteByid(Long id) throws NullPointerException {
        if(moduloRepository.existsById(id)) {
            moduloRepository.deleteById(id);
        }else {
            throw new NullPointerException("non presente");
        }
    }

    @Override
    public List<ModuloResponseDTO> findAllModuli() {
        List<Modulo> list = moduloRepository.findAll();
        return moduloResponseMapper.asDTOList(list);
    }
}
