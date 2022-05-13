package it.unikey.assessmentproject.BLL.service.abstraction;

import it.unikey.assessmentproject.BLL.DTO.request.DocenteRequestDTO;
import it.unikey.assessmentproject.BLL.DTO.response.DocenteResponseDTO;
import it.unikey.assessmentproject.BLL.service.Exception.EntityNotFoundException;

import java.util.List;


public interface DocenteService {

    void saveDocente(DocenteRequestDTO docenteRequestDTO);

    DocenteResponseDTO getDocenteById(Long id) throws EntityNotFoundException;

    void deleteDocenteById(Long id) throws EntityNotFoundException;

    List<DocenteResponseDTO> getAllDocente();


}
