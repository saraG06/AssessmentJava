package it.unikey.testfinale.BLL.service.impl;

import it.unikey.testfinale.BLL.mapper.dto.request.DiscenteRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.DiscenteResponseDTO;
import it.unikey.testfinale.BLL.mapper.implementation.request.AcademyRequestMapper;
import it.unikey.testfinale.BLL.mapper.implementation.request.DiscenteRequestMapper;
import it.unikey.testfinale.BLL.mapper.implementation.response.AcademyResponseMapper;
import it.unikey.testfinale.BLL.mapper.implementation.response.DiscenteResponseMapper;
import it.unikey.testfinale.BLL.service.abstraction.DiscenteService;
import it.unikey.testfinale.DAL.Entity.Discente;
import it.unikey.testfinale.DAL.Repository.AcademyRepository;
import it.unikey.testfinale.DAL.Repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DiscenteServiceImpl implements DiscenteService {

    private final DiscenteRepository discenteRepository;
    private final DiscenteRequestMapper discenteRequestMapper;
    private final DiscenteResponseMapper discenteResponseMapper;
    private final AcademyRequestMapper academyRequestMapper;
    private final AcademyResponseMapper academyResponseMapper;

    @Override
    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO){
        Discente d= discenteRequestMapper.asEntity(discenteRequestDTO);
        d.setAcademy(academyRequestMapper.asEntity(discenteRequestDTO.getAcademyRequestDTO()));
        discenteRepository.save(d);
    }

    @Override
    public DiscenteResponseDTO findById(Long id) {
        Discente d= discenteRepository.findById(id).get();
        if(d!=null) {
            DiscenteResponseDTO dResDTO = discenteResponseMapper.asDTO(d);
            dResDTO.setAcademyResponseDTO(academyResponseMapper.asDTO(d.getAcademy()));
            return dResDTO;
        }
        else
            throw new EntityNotFoundException();
    }

    @Override
    public void deleteById(Long id) {
        Discente d= discenteRepository.findById(id).get();
        if(d!=null)
            discenteRepository.delete(d);
        else
            throw new EntityNotFoundException();
    }

    @Override
    public List<DiscenteResponseDTO> findAllDiscente() {
        List<Discente> discenteList= discenteRepository.findAll();
        List<DiscenteResponseDTO> discenteRList= new ArrayList<>();
        for(Discente d : discenteList){
            DiscenteResponseDTO dResDTO = discenteResponseMapper.asDTO(d);
            dResDTO.setAcademyResponseDTO(academyResponseMapper.asDTO(d.getAcademy()));
            discenteRList.add(dResDTO);
        }
        return discenteRList;
    }
}
