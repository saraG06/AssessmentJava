package com.example.assessment.BLL.dto.response;

import lombok.Data;

@Data

public class ModuloResponseDTO {

    private Long id;
    private String nome;
    private String argomento;
    private String docente;
    private String dataInizio;
    private String dataFine;
    private AcademyResponseDTO academyResponseDTO;
}
