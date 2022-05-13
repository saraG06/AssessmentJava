package it.unikey.assessmentjavaleonardopaolini.BLL.service.implementation;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.DocenteRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.ModuloRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response.AcademyResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response.DocenteResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response.ModuloResponseMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.ModuloService;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Academy;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Docente;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Modulo;
import it.unikey.assessmentjavaleonardopaolini.DAL.Repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModuloServiceImplementation implements ModuloService {

    private final ModuloRepository moduloRepository;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;

    private final DocenteRequestMapper docenteRequestMapper;
    private final AcademyRequestMapper academyRequestMapper;

    private final DocenteResponseMapper docenteResponseMapper;
    private final AcademyResponseMapper academyResponseMapper;

    @Override
    public void saveModulo(ModuloRequestDTO moduloRequestDTO) {
        Modulo m = moduloRequestMapper.asEntity(moduloRequestDTO);
        Docente d = docenteRequestMapper.asEntity(moduloRequestDTO.getDocenteRequestDTO());
        Academy a = academyRequestMapper.asEntity(moduloRequestDTO.getAcademyRequestDTO());
        m.setDocente(d);
        m.setAcademy(a);
        moduloRepository.save(m);
    }
}
