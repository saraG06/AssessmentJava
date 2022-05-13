package it.unikey.assessmentjava.BLL.service.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.DocenteRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.DocenteResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementation.DocenteRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementation.DocenteResponseMapper;
import it.unikey.assessmentjava.BLL.service.abstraction.DocenteService;
import it.unikey.assessmentjava.DAL.repository.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;
    private final DocenteRequestMapper docenteRequestMapper;
    private final DocenteResponseMapper docenteResponseMapper;

    @Override
    public void saveDocente(DocenteRequestDTO docenteRequestDTO) {

    }

    @Override
    public List<DocenteResponseDTO> findAllDocente() {
        return null;
    }

    @Override
    public DocenteResponseDTO findDocenteById(Long id) {
        return null;
    }

    @Override
    public void deleteDocenteById(Long id) {

    }
}
