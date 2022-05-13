package it.unikey.assessmentproject.BLL.service.implementation;

import it.unikey.assessmentproject.BLL.DTO.request.DiscenteRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.DiscenteResponseDTO;
import it.unikey.assessmentproject.BLL.mapper.implementation.DiscenteRequestMapper;
import it.unikey.assessmentproject.BLL.mapper.implementation.DiscenteResponseMapper;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;
import it.unikey.assessmentproject.BLL.service.abstraction.DiscenteService;
import it.unikey.assessmentproject.DAL.repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscenteServiceImpl implements DiscenteService {

    private final DiscenteRepository discenteRepository;
    private final DiscenteResponseMapper discenteResponseMapper;
    private final DiscenteRequestMapper discenteRequestMapper;

    @Override
    public void saveDiscente(DiscenteRequestDTO discenteRequestDTO) {

        discenteRepository.save(discenteRequestMapper.asEntity(discenteRequestDTO));

    }

    @Override
    public DiscenteResponseDTO getDiscenteById(Long id) throws EntityNotFoundException {
        if(discenteRepository.findById(id).get() == null){
            throw new EntityNotFoundException("L'id inserito non è associato ad alcun discente");
        }else return discenteResponseMapper.asDTO(discenteRepository.findById(id).get());
    }

    @Override
    public void deleteDiscenteById(Long id) throws EntityNotFoundException {
        if (discenteRepository.findById(id).get() == null) {
            throw new EntityNotFoundException("L'id inserito non è associato ad alcun discente");
        }else discenteRepository.delete(discenteRepository.findById(id).get());

    }

    @Override
    public List<DiscenteResponseDTO> getAllDiscente() {
        return discenteResponseMapper.asDTOList(discenteRepository.findAll());
    }
}
