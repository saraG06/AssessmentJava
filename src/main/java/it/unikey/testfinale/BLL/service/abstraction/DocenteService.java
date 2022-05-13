package it.unikey.testfinale.BLL.service.abstraction;

import it.unikey.testfinale.BLL.mapper.dto.request.DocenteRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.DocenteResponseDTO;

import java.util.List;

public interface DocenteService {

    void saveDocente(DocenteRequestDTO docenteRequestDTO);

    DocenteResponseDTO findById(Long id);

    void deleteById(Long id);

    List<DocenteResponseDTO> findAllDocente();

    DocenteResponseDTO findByEmail(String email);
}
