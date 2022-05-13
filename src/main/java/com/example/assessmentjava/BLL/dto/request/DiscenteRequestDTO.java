package com.example.assessmentjava.BLL.dto.request;

import com.example.assessmentjava.DAL.Entity.Academy;
import lombok.Data;

@Data
public class DiscenteRequestDTO {
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private AcademyRequestDTO academyRequestDTO;
}
