package com.example.assessmentjava.BLL.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloRequestDto {


    private String nome;
    private String argomenti;
    private String docente;
    private LocalDate dataInizioModulo;
    private LocalDate dataFineModulo;
    private AcademyRequestDto academyRequestDto;
}
