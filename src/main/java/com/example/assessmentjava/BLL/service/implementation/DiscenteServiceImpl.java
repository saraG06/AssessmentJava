package com.example.assessmentjava.BLL.service.implementation;

import com.example.assessmentjava.BLL.dto.request.DiscenteRequestDto;
import com.example.assessmentjava.BLL.dto.response.DiscenteResponseDto;
import com.example.assessmentjava.BLL.mapper.implementation.DiscenteRequestMapper;
import com.example.assessmentjava.BLL.mapper.implementation.DiscenteResponseMapper;
import com.example.assessmentjava.BLL.service.abstraction.DiscenteService;
import com.example.assessmentjava.DAL.Entity.Academy;
import com.example.assessmentjava.DAL.Entity.Discente;
import com.example.assessmentjava.DAL.Repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscenteServiceImpl implements DiscenteService {

    private final DiscenteRepository discenteRepository;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;

    @Override
    public void saveDiscente(DiscenteRequestDto discenteRequestDto) {
        Discente d = discenteRequestMapper.asEntity(discenteRequestDto);
        discenteRepository.save(d);
    }

    @Override
    public DiscenteResponseDto findById(Long id) {
        Discente d = discenteRepository.getById(id);
        if (d != null) {
            discenteRepository.findById(id);
        } else throw new NullPointerException();

        return discenteResponseMapper.asDto(d);
    }

    @Override
    public void deleteDiscenteById(Long id) throws NullPointerException {
        Discente d = discenteRepository.getById(id);
        if(d!=null){
            discenteRepository.deleteById(id);
        }
        else {
            throw new NullPointerException();
        }
    }

    @Override
    public List<DiscenteResponseDto> findAllDiscente() {
        List<Discente> a1 = discenteRepository.findAll();
        return discenteResponseMapper.asDTOList(a1);
    }
}
