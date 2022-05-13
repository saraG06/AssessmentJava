package com.example.assessmentjava.BLL.service.implementation;

import com.example.assessmentjava.BLL.dto.request.ModuloRequestDto;
import com.example.assessmentjava.BLL.dto.response.ModuloResponseDto;
import com.example.assessmentjava.BLL.mapper.implementation.ModuloRequestMapper;
import com.example.assessmentjava.BLL.mapper.implementation.ModuloResponseMapper;
import com.example.assessmentjava.BLL.service.abstraction.ModuloService;
import com.example.assessmentjava.DAL.Entity.Academy;
import com.example.assessmentjava.DAL.Entity.Discente;
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
    @Override
    public void saveModulo(ModuloRequestDto moduloRequestDto) {
       Modulo m = moduloRequestMapper.asEntity(moduloRequestDto);
        moduloRepository.save(m);
    }

    @Override
    public ModuloResponseDto findById(Long id) {
        Modulo m =  moduloRepository.getById(id);
        if (m!= null) {
            moduloRepository.findById(id);
        } else throw new NullPointerException();

        return moduloResponseMapper.asDto(m);
    }

    @Override
    public void deleteModuloById(Long id) throws NullPointerException{
        Modulo m = moduloRepository.getById(id);
        if(m!=null){
            moduloRepository.deleteById(id);
        }
        else {
            throw new NullPointerException();
        }
    }

    @Override
    public List<ModuloResponseDto> findAllModulo() {
        List<Modulo> m = moduloRepository.findAll();
        return moduloResponseMapper.asDTOList(m);
    }
}
