package com.example.assessment.BLL.dto.response;

import lombok.Data;

@Data

public class DiscenteResponseDTO {

    private Long id;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private AcademyResponseDTO academyResponseDTO;
}
