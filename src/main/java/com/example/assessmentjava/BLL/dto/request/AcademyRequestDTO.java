package com.example.assessmentjava.BLL.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Data
public class AcademyRequestDTO implements Serializable {
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<ModuloRequestDTO> moduloRequestDTOList;
    private List<DiscenteRequestDTO> discenteRequestDTOList;
}
