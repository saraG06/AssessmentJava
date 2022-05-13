package it.unikey.assessmentproject.BLL.service.implementation;

import it.unikey.assessmentproject.BLL.DTO.request.DocenteRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.DocenteResponseDTO;
import it.unikey.assessmentproject.BLL.mapper.implementation.DocenteRequestMapper;
import it.unikey.assessmentproject.BLL.mapper.implementation.DocenteResponseMapper;
import it.unikey.assessmentproject.BLL.mapper.implementation.ModuloRequestMapper;
import it.unikey.assessmentproject.BLL.mapper.implementation.ModuloResponseMapper;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;
import it.unikey.assessmentproject.BLL.service.abstraction.DocenteService;
import it.unikey.assessmentproject.DAL.entity.Modulo;
import it.unikey.assessmentproject.DAL.repository.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;
    private final DocenteRequestMapper docenteRequestMapper;
    private final DocenteResponseMapper docenteResponseMapper;
    private final ModuloRequestMapper moduloRequestMapper;
    private final ModuloResponseMapper moduloResponseMapper;

    @Override
    public void saveDocente(DocenteRequestDTO docenteRequestDTO) {

        List<Modulo> moduloList = moduloRequestMapper.asEntityList(docenteRequestDTO.getModuloRequestDTOList());
        docenteRequestMapper.asEntity(docenteRequestDTO).setModuloList(moduloList);
        docenteRepository.save(docenteRequestMapper.asEntity(docenteRequestDTO));

    }

    @Override
    public DocenteResponseDTO getDocenteById(Long id) throws EntityNotFoundException {
        if(docenteRepository.findById(id).get() == null) {
            throw new EntityNotFoundException("L'id inserito non è associato a nessun docente");
        }else return docenteResponseMapper.asDTO(docenteRepository.findById(id).get());
    }

    @Override
    public void deleteDocenteById(Long id) throws EntityNotFoundException {
        if(docenteRepository.findById(id).get() == null) {
            throw new EntityNotFoundException("L'id inserito non è associato a nessun docente");
        }else docenteRepository.delete(docenteRepository.findById(id).get());

    }

    @Override
    public List<DocenteResponseDTO> getAllDocente() {
        return docenteResponseMapper.asDTOList(docenteRepository.findAll());
    }
}
