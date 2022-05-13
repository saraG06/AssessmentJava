package com.example.assessmentfinale.BLL.service.abstraction;

import com.example.assessmentfinale.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessmentfinale.BLL.dto.response.DiscenteResponseDTO;

public interface DiscenteService {

    void saveDiscente(DiscenteRequestDTO discenteRequestDTO);

    DiscenteResponseDTO getById(Long id);

}
