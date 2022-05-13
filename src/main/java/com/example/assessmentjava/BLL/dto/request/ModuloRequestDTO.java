package com.example.assessmentjava.BLL.dto.request;

import com.example.assessmentjava.DAL.Entity.Academy;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ModuloRequestDTO {
    private String nome;
    private String argomento;
    private String docente;
    private LocalDate dataInizioModulo;
    private LocalDate dataFineModulo;
    private AcademyRequestDTO academyRequestDTO;
}
