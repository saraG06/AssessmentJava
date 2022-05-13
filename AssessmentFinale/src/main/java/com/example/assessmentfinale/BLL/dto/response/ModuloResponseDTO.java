package com.example.assessmentfinale.BLL.dto.response;

import com.example.assessmentfinale.DAL.entities.Academy;
import com.example.assessmentfinale.DAL.entities.Discente;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ModuloResponseDTO {

    private Long id;
    private String nome;
    private String programma;
    private String docente;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<Discente> discentiModulo;
    private Academy academy;

}
