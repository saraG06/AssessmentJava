package it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.ModuloRequestDTOCreazione;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.ModuloResponseDTO;

import java.util.List;

public interface ModuloService {

    void saveModulo(ModuloRequestDTO moduloRequestDTO);

    void saveModuloCreazione(ModuloRequestDTOCreazione moduloRequestDTOCreazione);

    void deleteModuloById (Long id);

    List<ModuloResponseDTO> findAllModulo();
}
