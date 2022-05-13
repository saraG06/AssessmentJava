package com.example.assessment.BLL.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyRequestDTO {

    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<ModuloRequestDTO> moduloRequestDTOList;
    private List<DiscenteRequestDTO> discenteRequestDTOList;
}
