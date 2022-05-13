package it.unikey.assessmentproject.BLL.service.implementation;

import it.unikey.assessmentproject.BLL.DTO.request.AcademyRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.AcademyResponseDTO;
import it.unikey.assessmentproject.BLL.mapper.implementation.*;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;
import it.unikey.assessmentproject.BLL.service.abstraction.AcademyService;
import it.unikey.assessmentproject.DAL.entity.Discente;

import it.unikey.assessmentproject.DAL.entity.Modulo;
import it.unikey.assessmentproject.DAL.repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyResponseMapper academyResponseMapper;
    private final AcademyRequestMapper academyRequestMapper;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final ModuloRequestMapper moduloRequestMapper;


    @Override
    public void saveAcademy(AcademyRequestDTO academyRequestDTO) {

        List<Discente> discenteList = discenteRequestMapper.asEntityList(academyRequestDTO.getDiscenteRequestDTOList());
        academyRequestMapper.asEntity(academyRequestDTO).setDiscenteList(discenteList);
        List<Modulo> moduloList = moduloRequestMapper.asEntityList(academyRequestDTO.getModuloRequestDTOList());
        academyRequestMapper.asEntity(academyRequestDTO).setModuloList(moduloList);
        academyRepository.save(academyRequestMapper.asEntity(academyRequestDTO));
    }

    @Override
    public AcademyResponseDTO getAcademyById(Long id) throws EntityNotFoundException {
        if(academyRepository.findById(id).get() == null){
            throw new EntityNotFoundException("L'id inserito non corrisponde a nessuna academy");
        }else return academyResponseMapper.asDTO(academyRepository.findById(id).get());
    }

    @Override
    public void deleteAcademyById(Long id) throws EntityNotFoundException {
        if(academyRepository.findById(id).get() == null) {
            throw new EntityNotFoundException("L'id inserito non corrisponde a nessuna academy");
        }else academyRepository.delete(academyRepository.findById(id).get());
    }

    @Override
    public List<AcademyResponseDTO> getAllAcademy() {
        return academyResponseMapper.asDTOList(academyRepository.findAll());
    }
}
