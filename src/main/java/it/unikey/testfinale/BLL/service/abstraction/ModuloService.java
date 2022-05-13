package it.unikey.testfinale.BLL.service.abstraction;

import it.unikey.testfinale.BLL.Exception.AlreadyExistsException;
import it.unikey.testfinale.BLL.Exception.ConflictBetweenAttributesException;
import it.unikey.testfinale.BLL.mapper.dto.request.ModuloRequestDTO;
import it.unikey.testfinale.BLL.mapper.dto.response.ModuloResponseDTO;
import java.util.List;

public interface ModuloService {

    void saveModulo(ModuloRequestDTO moduloRequestDTO) throws AlreadyExistsException, ConflictBetweenAttributesException;

    ModuloResponseDTO findById(Long id);

    void deleteById(Long id);

    List<ModuloResponseDTO> findAllModulo();
}
