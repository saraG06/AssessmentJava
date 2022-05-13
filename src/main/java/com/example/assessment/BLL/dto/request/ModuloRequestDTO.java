package com.example.assessment.BLL.dto.request;

import lombok.Data;

@Data

public class ModuloRequestDTO {

    private String nome;
    private String argomento;
    private String docente;
    private String dataInizio;
    private String dataFine;
    private AcademyRequestDTO academyRequestDTO;
}
