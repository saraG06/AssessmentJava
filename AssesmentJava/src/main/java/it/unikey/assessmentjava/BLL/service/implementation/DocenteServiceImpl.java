package it.unikey.assessmentjava.BLL.service.implementation;

import it.unikey.assessmentjava.BLL.DTO.request.DocenteRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.DocenteResponseDTO;
import it.unikey.assessmentjava.BLL.mapper.implementation.DocenteRequestMapper;
import it.unikey.assessmentjava.BLL.mapper.implementation.DocenteResponseMapper;
import it.unikey.assessmentjava.BLL.service.abstraction.DocenteService;
import it.unikey.assessmentjava.DAL.entity.Docente;
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
        Docente d = docenteRequestMapper.asEntity(docenteRequestDTO);
        docenteRepository.save(d);
    }

    @Override
    public List<DocenteResponseDTO> findAllDocente() {
        List<Docente> dList = docenteRepository.findAll();
        return docenteResponseMapper.asDTOList(dList);
    }

    @Override
    public DocenteResponseDTO findDocenteById(Long id) throws NullPointerException{
        Docente d = docenteRepository.getById(id);
        if(id != null)
            return docenteResponseMapper.asDTO(d);
        else
            throw new NullPointerException();
    }

    @Override
    public void deleteDocenteById(Long id) throws NullPointerException{
        if(docenteRepository.existsById(id))
            docenteRepository.deleteById(id);
        else
            throw new NullPointerException();
    }
}
