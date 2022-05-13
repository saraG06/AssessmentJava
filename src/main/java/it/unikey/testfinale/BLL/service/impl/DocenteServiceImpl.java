package it.unikey.testfinale.BLL.service.impl;

import it.unikey.testfinale.BLL.mapper.dto.request.DocenteRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.DiscenteResponseDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.DocenteResponseDTO;
import it.unikey.testfinale.BLL.mapper.implementation.request.DocenteRequestMapper;
import it.unikey.testfinale.BLL.mapper.implementation.request.ModuloRequestMapper;
import it.unikey.testfinale.BLL.mapper.implementation.response.DocenteResponseMapper;
import it.unikey.testfinale.BLL.mapper.implementation.response.ModuloResponseMapper;
import it.unikey.testfinale.BLL.service.abstraction.DocenteService;
import it.unikey.testfinale.DAL.Entity.Discente;
import it.unikey.testfinale.DAL.Entity.Docente;
import it.unikey.testfinale.DAL.Entity.Modulo;
import it.unikey.testfinale.DAL.Repository.DocenteRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DocenteServiceImpl implements DocenteService {

    private DocenteRepository docenteRepository;
    private DocenteRequestMapper docenteRequestMapper;
    private DocenteResponseMapper docenteResponseMapper;
    private ModuloRequestMapper moduloRequestMapper;
    private ModuloResponseMapper moduloResponseMapper;


    @Override
    public void saveDocente(DocenteRequestDTO docenteRequestDTO) {
        Docente d= docenteRequestMapper.asEntity(docenteRequestDTO);
        d.setModuloList(moduloRequestMapper.asEntityList(docenteRequestDTO.getModuloRequestDTOList()));
        docenteRepository.save(d);
    }

    @Override
    public DocenteResponseDTO findById(Long id) {
        Docente d= docenteRepository.findById(id).get();
        if(d!=null){
            DocenteResponseDTO dResDTO= docenteResponseMapper.asDTO(d);
            dResDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(d.getModuloList()));
            return dResDTO;
        }
        else
            throw new EntityNotFoundException();
    }

    @Override
    public void deleteById(Long id) {
        Docente d= docenteRepository.findById(id).get();
        if(d!=null)
            docenteRepository.delete(d);
        else
            throw new EntityNotFoundException();
    }

    @Override
    public List<DocenteResponseDTO> findAllDocente() {
        List<Docente> docenteList= docenteRepository.findAll();
        List<DocenteResponseDTO> docenteRList= new ArrayList<>();
        for(Docente d : docenteList){
            DocenteResponseDTO dResDTO = docenteResponseMapper.asDTO(d);
            dResDTO.setModuloResponseDTOList(moduloResponseMapper.asDTOList(d.getModuloList()));
            docenteRList.add(dResDTO);
        }
        return docenteRList;
    }
}
