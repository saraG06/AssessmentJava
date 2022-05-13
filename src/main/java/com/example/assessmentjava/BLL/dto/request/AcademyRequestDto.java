package com.example.assessmentjava.BLL.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyRequestDto {

    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<ModuloRequestDto> moduloRequestDtoList;
    private List<DiscenteRequestDto> discenteRequestDtoList;
}
