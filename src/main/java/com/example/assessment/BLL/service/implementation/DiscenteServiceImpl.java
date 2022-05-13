package com.example.assessment.BLL.service.implementation;

import com.example.assessment.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessment.BLL.dto.response.DiscenteResponseDTO;
import com.example.assessment.BLL.mapper.implementation.DiscenteRequestMapper;
import com.example.assessment.BLL.mapper.implementation.DiscenteResponseMapper;
import com.example.assessment.BLL.service.abstraction.DiscenteService;
import com.example.assessment.DAL.entity.Discente;
import com.example.assessment.DAL.repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscenteServiceImpl implements DiscenteService {

    private final DiscenteRepository discenteRepository;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;

    @Override
    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO) {
        Discente d = discenteRequestMapper.asEntity(discenteRequestDTO);
        discenteRepository.save(d);
    }

    @Override
    public DiscenteResponseDTO findDiscenteById(Long id) throws NullPointerException {
        Discente d = discenteRepository.getById(id);

        if (id != null) {
            return discenteResponseMapper.asDTO(d);
        } else throw new NullPointerException();
    }
}
