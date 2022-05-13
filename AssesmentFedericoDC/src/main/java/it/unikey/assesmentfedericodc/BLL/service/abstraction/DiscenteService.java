package it.unikey.assesmentfedericodc.BLL.service.abstraction;

import it.unikey.assesmentfedericodc.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.DiscenteResponseDTO;

import java.util.List;

public interface DiscenteService {

    void saveDiscente(DiscenteRequestDTO discenteRequestDTO);
    DiscenteResponseDTO findById(Long id) ;
    void deleteDiscenteById(Long id) ;
    List<DiscenteResponseDTO> findAllDiscente();
}
