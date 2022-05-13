package it.unikey.testfinale.BLL.service.abstraction;

import it.unikey.testfinale.BLL.mapper.dto.request.DiscenteRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.DiscenteResponseDTO;

import java.util.List;

public interface DiscenteService {

    void saveDiscente(DiscenteRequestDTO discenteRequestDTO);

    DiscenteResponseDTO findById(Long id);

    void deleteById(Long id);

    List<DiscenteResponseDTO> findAllDiscente();
}
