package it.unikey.assestmentjava.BLL.service.abstraction;

import it.unikey.assestmentjava.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assestmentjava.BLL.dto.response.ModuloResponseDTO;

import java.util.List;

public interface ModuloService {

    void save(ModuloRequestDTO moduloRequestDTO);

    ModuloResponseDTO findById(Long id);

    void deleteById(Long id);

    List<ModuloResponseDTO> findAll();
}
