package it.unikey.assesmentfedericodc.BLL.service.abstraction;

import it.unikey.assesmentfedericodc.BLL.dto.request.DiscenteRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.DiscenteResponseDTO;
import it.unikey.assesmentfedericodc.DAL.exception.CodiceFiscaleNonValidoException;

import java.util.List;

public interface DiscenteService {

    void saveDiscente(DiscenteRequestDTO discenteRequestDTO) throws CodiceFiscaleNonValidoException;
    DiscenteResponseDTO findById(Long id) ;
    void deleteDiscenteById(Long id) ;
    List<DiscenteResponseDTO> findAllDiscente();
}
