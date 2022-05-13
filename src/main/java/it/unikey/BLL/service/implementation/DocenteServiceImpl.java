package it.unikey.BLL.service.implementation;

import it.unikey.BLL.dto.request.DocenteRequestDTO;
import it.unikey.BLL.dto.response.DocenteResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;
import it.unikey.BLL.mapper.implementation.request.DiscenteRequestMapper;
import it.unikey.BLL.mapper.implementation.request.DocenteRequestMapper;
import it.unikey.BLL.mapper.implementation.request.ModuloRequestMapper;
import it.unikey.BLL.mapper.implementation.response.DocenteResponseMapper;
import it.unikey.BLL.service.abstraction.DocenteService;
import it.unikey.DAL.entity.Docente;
import it.unikey.DAL.entity.Modulo;
import it.unikey.DAL.repository.DocenteRepository;
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

    @Override
    public void saveDocente(DocenteRequestDTO docenteRequestDTO) {
        Docente d = docenteRequestMapper.asEntity(docenteRequestDTO);
        Modulo m = moduloRequestMapper.asEntity(docenteRequestDTO.getModuloRequestDTO());
        d.setModulo(m);
        docenteRepository.save(d);
    }

    @Override
    public DocenteResponseDTO findById(Long id) throws IdNotFoundException {
        Docente d = null;
        if (docenteRepository.findById(id).isPresent()) {
            d = docenteRepository.findById(id).get();
        }
        if(d == null){
            throw new IdNotFoundException("Id " + id + " non è presente nel db");
        }
        else {
            return docenteResponseMapper.asDto(d);
        }
    }


    @Override
    public void deleteDocente(Long id) throws IdNotFoundException {
        if(docenteRepository.findById(id).isPresent()) {
            Docente d = docenteRepository.findById(id).get();
            if (d != null) {
                docenteRepository.delete(d);
            } else {
                throw new IdNotFoundException("Id " + id + " non è presente nel db");
            }
        }
    }

    @Override
    public List<DocenteResponseDTO> findAllDocente() {
        return docenteResponseMapper.asDTOList(docenteRepository.findAll());
    }
}
