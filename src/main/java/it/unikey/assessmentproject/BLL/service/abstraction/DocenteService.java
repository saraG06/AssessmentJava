package it.unikey.assessmentproject.BLL.service.abstraction;

import it.unikey.assessmentproject.BLL.DTO.request.DocenteRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.DocenteResponseDTO;

import java.util.List;


public interface DocenteService {

    void saveDocente(DocenteRequestDTO docenteRequestDTO);

    DocenteResponseDTO getDocenteById(Long id);

    void deleteDocenteById(Long id);

    List<DocenteResponseDTO> getAllDocente();


}
