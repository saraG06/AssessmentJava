package it.unikey.assestmentjava.BLL.service.impl;

import it.unikey.assestmentjava.BLL.dto.request.DocenteRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.DocenteResponseDTO;
import it.unikey.assestmentjava.BLL.mapper.implementation.DocenteRequestMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.DocenteResponseMapper;
import it.unikey.assestmentjava.BLL.mapper.implementation.PersonaRequestMapper;
import it.unikey.assestmentjava.BLL.service.abstraction.DocenteService;
import it.unikey.assestmentjava.DAL.entity.Docente;
import it.unikey.assestmentjava.DAL.entity.Persona;
import it.unikey.assestmentjava.DAL.repository.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;
    private final DocenteRequestMapper docenteRequestMapper;
    private final DocenteResponseMapper docenteResponseMapper;
    private final PersonaRequestMapper personaRequestMapper;

    @Override
    public void save(DocenteRequestDTO docenteRequestDTO) {
        Docente d = docenteRequestMapper.asEntity(docenteRequestDTO);
        Persona p = personaRequestMapper.asEntity(docenteRequestDTO.getPersonaRequestDTO());
        d.setPersona(p);
        docenteRepository.save(d);
    }

    @Override
    public DocenteResponseDTO findById(Long id) {
        Docente d = docenteRepository.getById(id);
        if(d != null){
            return docenteResponseMapper.asDTO(d);
        }else{
            throw new NullPointerException();
        }
    }

    @Override
    public void deleteById(Long id) {
        if(docenteRepository.existsById(id)){
            docenteRepository.deleteById(id);
        }else{
            throw new NullPointerException();
        }
    }

    @Override
    public List<DocenteResponseDTO> findAll() {
        List<Docente> list = docenteRepository.findAll();
        return docenteResponseMapper.asDTOList(list);
    }
}
