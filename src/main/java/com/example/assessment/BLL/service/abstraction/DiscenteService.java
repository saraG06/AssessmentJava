package com.example.assessment.BLL.service.abstraction;

import com.example.assessment.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessment.BLL.dto.response.DiscenteResponseDTO;

public interface DiscenteService {

    void saveDiscente (DiscenteRequestDTO discenteRequestDTO);

    DiscenteResponseDTO findDiscenteById(Long id);
}
