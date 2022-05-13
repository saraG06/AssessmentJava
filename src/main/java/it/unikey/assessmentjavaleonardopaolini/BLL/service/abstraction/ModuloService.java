package it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.ModuloRequestDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.ModuloResponseDTO;

import java.util.List;

public interface ModuloService {

    void saveModulo(ModuloRequestDTO moduloRequestDTO);

    List<ModuloResponseDTO> findAllModulo();
}
