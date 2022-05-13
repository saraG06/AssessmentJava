package com.example.assessmentjava.BLL.dto.response;

import com.example.assessmentjava.BLL.dto.request.DiscenteRequestDto;
import com.example.assessmentjava.BLL.dto.request.ModuloRequestDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data

public class AcademyResponseDto {
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<ModuloResponseDto> moduloResponseDtoList;
   private List<DiscenteResponseDto> discenteResponseDtoList;
}
