package com.example.assessmentjava.BLL.dto.response;

import com.example.assessmentjava.BLL.dto.request.AcademyRequestDto;
import lombok.Data;

@Data
public class DiscenteResponseDto {

    private String codiceFiscale;
    private String nome;
    private String cognome;
    private AcademyResponseDto academyResponseDto;
}
