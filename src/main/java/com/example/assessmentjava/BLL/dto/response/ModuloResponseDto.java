package com.example.assessmentjava.BLL.dto.response;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDto;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ModuloResponseDto {

    private String nome;
    private String argomenti;
    private String docente;
    private LocalDate dataInizioModulo;
    private LocalDate dataFineModulo;
    private AcademyResponseDto academyResponseDto;
}
