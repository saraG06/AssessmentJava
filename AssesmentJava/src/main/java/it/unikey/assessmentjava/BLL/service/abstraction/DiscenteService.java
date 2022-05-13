package it.unikey.assessmentjava.BLL.service.abstraction;

import it.unikey.assessmentjava.BLL.DTO.request.DiscenteRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.DiscenteResponseDTO;

import java.util.List;

public interface DiscenteService {

    void saveDiscente(DiscenteRequestDTO discenteRequestDTO);

    List<DiscenteResponseDTO> findAllDiscente();

    DiscenteResponseDTO findDiscenteById(Long id);

    void deleteDiscenteById(Long id);
}
