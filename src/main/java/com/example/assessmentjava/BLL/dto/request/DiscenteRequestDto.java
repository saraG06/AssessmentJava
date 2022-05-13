package com.example.assessmentjava.BLL.dto.request;

import lombok.Data;

@Data
public class DiscenteRequestDto {

    private String codiceFiscale;
    private String nome;
    private String cognome;
    private AcademyRequestDto academyRequestDto;
}
