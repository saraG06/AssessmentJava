package com.example.assessmentjava.BLL.service.abstraction;

import com.example.assessmentjava.BLL.dto.request.DiscenteRequestDTO;
import com.example.assessmentjava.BLL.dto.response.DiscenteResponseDTO;

import java.util.List;

public interface DiscenteService {
    void saveDiscente (DiscenteRequestDTO discenteRequestDTO);
    DiscenteResponseDTO findByid(Long id) throws NullPointerException;
    void deleteByid(Long id) throws NullPointerException;
    List<DiscenteResponseDTO> findAllDiscenti();
}
