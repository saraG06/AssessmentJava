package it.unikey.assessmentjava.BLL.service.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.DiscenteRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.DiscenteResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementation.DiscenteRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementation.DiscenteResponseMapper;
import it.unikey.assessmentjava.BLL.service.abstraction.DiscenteService;
import it.unikey.assessmentjava.DAL.repository.DiscenteRepository;
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
    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO) {

    }

    @Override
    public List<DiscenteResponseDTO> findAllDiscente() {
        return null;
    }

    @Override
    public DiscenteResponseDTO findDiscenteById(Long id) {
        return null;
    }

    @Override
    public void deleteDiscenteById(Long id) {

    }
}
