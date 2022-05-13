package com.example.assessment.BLL.dto.request;

import lombok.Data;

@Data

public class DiscenteRequestDTO {

    private String nome;
    private String cognome;
    private String codiceFiscale;
    private AcademyRequestDTO academyRequestDTO;
}
