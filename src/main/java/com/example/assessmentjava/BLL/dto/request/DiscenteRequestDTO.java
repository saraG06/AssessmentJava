package com.example.assessmentjava.BLL.dto.request;

import com.example.assessmentjava.DAL.Entity.Academy;
import lombok.Data;

import java.io.Serializable;

@Data
public class DiscenteRequestDTO implements Serializable {
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private AcademyRequestDTO academyRequestDTO;
}
