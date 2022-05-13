package com.example.assessmentjava.BLL.service.impl;

import com.example.assessmentjava.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessmentjava.BLL.dto.response.DiscenteResponseDTO;
import com.example.assessmentjava.BLL.mapper.implementation.AcademyRequestMapper;
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
    private final AcademyRequestMapper academyRequestMapper;
    @Override
    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO) {
        Discente d = discenteRequestMapper.asEntity(discenteRequestDTO);
        Academy academy= academyRequestMapper.asEntity(discenteRequestDTO.getAcademyRequestDTO());

        d.setAcademy(academy);

        discenteRepository.save(d);
    }

    @Override
    public DiscenteResponseDTO findByid(Long id) throws NullPointerException {
        Discente d = discenteRepository.getById(id);
        if(d != null)
            return discenteResponseMapper.asDTO(d);
        else
            throw new NullPointerException("non presente");
    }

    @Override
    public void deleteByid(Long id) throws NullPointerException {
        if(discenteRepository.existsById(id)) {
            discenteRepository.deleteById(id);
        }else {
            throw new NullPointerException("non presente");
        }
    }

    @Override
    public List<DiscenteResponseDTO> findAllDiscenti() {
        List<Discente> list = discenteRepository.findAll();
        return discenteResponseMapper.asDTOList(list);
    }
}
