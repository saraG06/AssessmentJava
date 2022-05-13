package com.example.assessmentfinale.BLL.service.impl;

import com.example.assessmentfinale.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessmentfinale.BLL.dto.response.DiscenteResponseDTO;
import com.example.assessmentfinale.BLL.mapper.impl.request.DiscenteRequestMapper;
import com.example.assessmentfinale.BLL.mapper.impl.response.DiscenteResponseMapper;
import com.example.assessmentfinale.BLL.service.abstraction.DiscenteService;
import com.example.assessmentfinale.DAL.entities.Discente;
import com.example.assessmentfinale.DAL.repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscenteServiceImpl implements DiscenteService {

    public DiscenteRepository discenteRepository;
    public DiscenteRequestMapper discenteRequestMapper;
    public DiscenteResponseMapper discenteResponseMapper;

    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO) {
        Discente d = discenteRequestMapper.asEntity(discenteRequestDTO);
        discenteRepository.save(d);
    }

    @Override
    public DiscenteResponseDTO getById(Long id) {
            Discente d = discenteRepository.getById(id);

            if (id != null) {
                return discenteResponseMapper.asDTO(d);
            } else throw new NullPointerException("Entity not found");
    }


}
