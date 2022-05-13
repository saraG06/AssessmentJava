package it.unikey.assessmentjavaleonardopaolini.BLL.service.implementation;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.DocenteRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.DocenteRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response.DocenteResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.DocenteService;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Academy;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Docente;
import it.unikey.assessmentjavaleonardopaolini.DAL.Repository.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocenteServiceImplementation implements DocenteService {

    private final DocenteRepository docenteRepository;
    private final DocenteRequestMapper docenteRequestMapper;
    private final DocenteResponseMapper docenteResponseMapper;

    @Override
    public void saveDocente(DocenteRequestDTO docenteRequestDTO) {
        Docente d = docenteRequestMapper.asEntity(docenteRequestDTO);
        docenteRepository.save(d);
    }
}
