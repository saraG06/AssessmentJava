package com.example.assessmentjava.BLL.service.abstraction;

import com.example.assessmentjava.BLL.dto.request.DiscenteRequestDto;
import com.example.assessmentjava.BLL.dto.response.AcademyResponseDto;
import com.example.assessmentjava.BLL.dto.response.DiscenteResponseDto;
import com.example.assessmentjava.DAL.Entity.Discente;

import java.util.List;

public interface DiscenteService {

    void saveDiscente (DiscenteRequestDto discenteRequestDto);
    DiscenteResponseDto findById (Long id);
    void deleteDiscenteById (Long id);

    List<DiscenteResponseDto> findAllDiscente();


}
