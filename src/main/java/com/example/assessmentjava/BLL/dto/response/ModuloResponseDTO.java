package com.example.assessmentjava.BLL.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
public class ModuloResponseDTO implements Serializable {
    private Long id;
    private String nome;
    private String argomento;
    private String docente;
    private LocalDate dataInizioModulo;
    private LocalDate dataFineModulo;
}
