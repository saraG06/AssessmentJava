package com.example.assessmentfinale.BLL.dto.request;

import com.example.assessmentfinale.DAL.entities.Academy;
import com.example.assessmentfinale.DAL.entities.Modulo;
import lombok.Data;

import java.util.List;

@Data
public class DiscenteRequestDTO {

    private String codiceFiscale;
    private String nome;
    private String congome;
    private List<Modulo> moduliStudente;
    private Academy academy;

}
