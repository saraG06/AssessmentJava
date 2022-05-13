package it.unikey.assessmentjava.BLL.service.abstraction;

import it.unikey.assessmentjava.BLL.DTO.request.DocenteRequestDTO;
import it.unikey.assessmentjava.BLL.DTO.response.DocenteResponseDTO;

import java.util.List;

public interface DocenteService {

    void saveDocente(DocenteRequestDTO docenteRequestDTO);

    List<DocenteResponseDTO> findAllDocente();

    DocenteResponseDTO findDocenteById(Long id);

    void deleteDocenteById(Long id);
}
