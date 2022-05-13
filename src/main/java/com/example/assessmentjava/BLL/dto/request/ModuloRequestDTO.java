package com.example.assessmentjava.BLL.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
public class ModuloRequestDTO implements Serializable {
    private String nome;
    private String argomento;
    private String docente;
    private LocalDate dataInizioModulo;
    private LocalDate dataFineModulo;
    private AcademyRequestDTO academyRequestDTO;
}
