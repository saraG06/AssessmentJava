package it.unikey.assessmentjavaleonardopaolini.BLL.service.implementation;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.ModuloRequestDTOCreazione;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.ModuloResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.DocenteRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.ModuloRequestMapper;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.request.ModuloRequestMapperCreazione;
import it.unikey.assessmentjavaleonardopaolini.BLL.mapper.implementation.response.*;
import it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction.ModuloService;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Academy;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Docente;
import it.unikey.assessmentjavaleonardopaolini.DAL.Entity.Modulo;
import it.unikey.assessmentjavaleonardopaolini.DAL.Repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuloServiceImplementation implements ModuloService {

    private final ModuloRepository moduloRepository;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;

    private final ModuloRequestMapperCreazione moduloRequestMapperCreazione;
    private final AcademyResponseMapper2 academyResponseMapper2;
    private final DocenteResponseMapper2 docenteResponseMapper2;



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

    @Override
    public void saveModuloCreazione(ModuloRequestDTOCreazione moduloRequestDTOCreazione) {
        Modulo m = moduloRequestMapperCreazione.asEntity(moduloRequestDTOCreazione);
        Docente d = docenteResponseMapper2.asDTO(moduloRequestDTOCreazione.getDocenteResponseDTO());
        Academy a = academyResponseMapper2.asDTO(moduloRequestDTOCreazione.getAcademyResponseDTO());
        m.setDocente(d);
        m.setAcademy(a);
        moduloRepository.save(m);
    }

    @Override
    public void deleteModuloById(Long id) {
        Modulo m = moduloRepository.getById(id);
        if(m !=null)
            moduloRepository.deleteById(id);
        else
            throw new NullPointerException();
    }

    @Override
    public List<ModuloResponseDTO> findAllModulo() {

        List<Modulo> lista = moduloRepository.findAll();
        List<ModuloResponseDTO> listDTO = moduloResponseMapper.asDTOList(lista);
        for(ModuloResponseDTO m : listDTO){
            for(Modulo mo : lista){
                m.setDocenteResponseDTO(docenteResponseMapper.asDTO(mo.getDocente()));
                m.setAcademyResponseDTO(academyResponseMapper.asDTO(mo.getAcademy()));
            }
        }

        return listDTO;

    }


}
