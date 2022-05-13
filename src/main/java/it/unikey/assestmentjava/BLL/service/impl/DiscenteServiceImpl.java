package it.unikey.assestmentjava.BLL.service.impl;

import it.unikey.assestmentjava.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.assestmentjava.BLL.mapper.implementation.AcademyRequestMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.DiscenteRequestMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.DiscenteResponseMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.PersonaRequestMapper;
import it.unikey.assestmentjava.BLL.service.abstraction.DiscenteService;
import it.unikey.assestmentjava.DAL.entity.Academy;
import it.unikey.assestmentjava.DAL.entity.Discente;
import it.unikey.assestmentjava.DAL.entity.Persona;
import it.unikey.assestmentjava.DAL.repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscenteServiceImpl implements DiscenteService {

    private final DiscenteRepository discenteRepository;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;
    private final PersonaRequestMapper personaRequestMapper;
    private final AcademyRequestMapper academyRequestMapper;

    @Override
    public void save(DiscenteRequestDTO discenteRequestDTO) {
        Discente d = discenteRequestMapper.asEntity(discenteRequestDTO);
        Persona p = personaRequestMapper.asEntity(discenteRequestDTO.getPersonaRequestDTO());
        Academy a = academyRequestMapper.asEntity(discenteRequestDTO.getAcademyRequestDTO());
        d.setPersona(p);
        d.setAcademy(a);
        discenteRepository.save(d);
    }

    @Override
    public DiscenteResponseDTO findById(Long id) {
        Discente d = discenteRepository.getById(id);
        if(d != null){
            return discenteResponseMapper.asDTO(d);
        }else{
            throw new NullPointerException();
        }
    }

    @Override
    public void deleteById(Long id) {
        if(discenteRepository.existsById(id)){
            discenteRepository.deleteById(id);
        }else{
            throw new NullPointerException();
        }
    }

    @Override
    public List<DiscenteResponseDTO> findAll() {
        List<Discente> list = discenteRepository.findAll();
        return discenteResponseMapper.asDTOList(list);
    }
}
