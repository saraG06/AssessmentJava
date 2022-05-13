package it.unikey.BLL.service.abstraction;

import it.unikey.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;

import java.util.List;

public interface DiscenteService {
    void saveDiscente(DiscenteRequestDTO discenteRequestDTO);
    DiscenteResponseDTO findById(Long id) throws IdNotFoundException;
    void deleteDiscente(Long id) throws IdNotFoundException;
    List<DiscenteResponseDTO> findAllDiscente();
}
