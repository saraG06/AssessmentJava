package it.unikey.assestmentjava.BLL.service.abstraction;

import it.unikey.assestmentjava.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.DiscenteResponseDTO;

import java.util.List;

public interface DiscenteService {

    void save(DiscenteRequestDTO discenteRequestDTO);

    DiscenteResponseDTO findById(Long id);

    void deleteById(Long id);

    List<DiscenteResponseDTO> findAll();
}
