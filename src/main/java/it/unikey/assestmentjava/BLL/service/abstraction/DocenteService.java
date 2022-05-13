package it.unikey.assestmentjava.BLL.service.abstraction;

import it.unikey.assestmentjava.BLL.dto.request.DocenteRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.DocenteResponseDTO;

import java.util.List;

public interface DocenteService {

    void save(DocenteRequestDTO docenteRequestDTO);

    DocenteResponseDTO findById(Long id);

    void deleteById(Long id);

    List<DocenteResponseDTO> findAll();
}
