package it.unikey.assessmentjavaleonardopaolini.BLL.service.implementation;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.DiscenteRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response.AcademyResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response.DiscenteResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.DiscenteService;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Academy;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Discente;
import it.unikey.assessmentjavaleonardopaolini.DAL.Repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscenteServiceImplementation implements DiscenteService {

    private final DiscenteRepository discenteRepository;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;

    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;

    @Override
    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO) {
        Discente d = discenteRequestMapper.asEntity(discenteRequestDTO);
        Academy a = academyRequestMapper.asEntity(discenteRequestDTO.getAcademyRequestDTO());
        d.setAcademy(a);
        discenteRepository.save(d);
    }

    @Override
    public void deleteDiscenteById(Long id) {
        Discente d = discenteRepository.getById(id);
        if(d !=null)
            discenteRepository.deleteById(id);
        else
            throw new NullPointerException();
    }
}
