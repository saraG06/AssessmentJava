package it.unikey.assessmentproject.BLL.service.abstraction;

import it.unikey.assessmentproject.BLL.DTO.request.DiscenteRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.DiscenteResponseDTO;

import java.util.List;

public interface DiscenteService {

    void saveDiscente(DiscenteRequestDTO discenteRequestDTO);

    DiscenteResponseDTO getDiscenteById(Long id);

    void deleteDiscenteById(Long id);

    List<DiscenteResponseDTO> getAllDiscente();

}
