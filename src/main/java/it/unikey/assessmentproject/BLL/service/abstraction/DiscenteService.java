package it.unikey.assessmentproject.BLL.service.abstraction;

import it.unikey.assessmentproject.BLL.DTO.request.DiscenteRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.DiscenteResponseDTO;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;

import java.util.List;

public interface DiscenteService {

    void saveDiscente(DiscenteRequestDTO discenteRequestDTO);

    DiscenteResponseDTO getDiscenteById(Long id) throws EntityNotFoundException;

    void deleteDiscenteById(Long id) throws EntityNotFoundException;

    List<DiscenteResponseDTO> getAllDiscente();

}
