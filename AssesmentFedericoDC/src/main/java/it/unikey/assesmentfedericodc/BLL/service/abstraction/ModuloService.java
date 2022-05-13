package it.unikey.assesmentfedericodc.BLL.service.abstraction;

import it.unikey.assesmentfedericodc.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assesmentfedericodc.BLL.dto.response.ModuloResponseDTO;

import java.util.List;

public interface ModuloService {

    void saveModulo(ModuloRequestDTO moduloRequestDTO);
    ModuloResponseDTO findById(Long id) ;
    void deleteModuloById(Long id) ;
    List<ModuloResponseDTO> findAllModulo();

}
