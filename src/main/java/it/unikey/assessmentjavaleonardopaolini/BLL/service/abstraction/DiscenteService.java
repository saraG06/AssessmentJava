package it.unikey.assessmentjavaleonardopaolini.BLL.service.abstraction;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.request.DiscenteRequestDTO;

public interface DiscenteService {

    void saveDiscente(DiscenteRequestDTO discenteRequestDTO);

    void deleteDiscenteById (Long id);
}
