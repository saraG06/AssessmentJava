package it.unikey.assessmentjava.BLL.service.astratti;

import it.unikey.assessmentjava.BLL.dto.request.DocenteRequestDTO;
import it.unikey.assessmentjava.BLL.dto.response.DocenteResponseDTO;

import java.util.List;

public interface DocenteService {
    void saveDocente(DocenteRequestDTO docenteRequestDTO);
    DocenteResponseDTO findById(Long id);
    void deleteById(Long id);
    List<DocenteResponseDTO> findAllDocenti();
}
