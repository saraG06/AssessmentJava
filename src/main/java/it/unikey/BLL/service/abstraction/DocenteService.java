package it.unikey.BLL.service.abstraction;

import it.unikey.BLL.dto.request.DocenteRequestDTO;
import it.unikey.BLL.dto.response.DocenteResponseDTO;
import it.unikey.BLL.exception.IdNotFoundException;

import java.util.List;

public interface DocenteService {
    void saveDocente(DocenteRequestDTO docenteRequestDTO);
    DocenteResponseDTO findById(Long id) throws IdNotFoundException;
    void deleteDocente(Long id) throws IdNotFoundException;
    List<DocenteResponseDTO> findAllDocente();
}
