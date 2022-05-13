package com.example.assessmentfinale.BLL.dto.response;

import com.example.assessmentfinale.DAL.entities.Academy;
import com.example.assessmentfinale.DAL.entities.Modulo;
import lombok.Data;

import java.util.List;

@Data
public class DiscenteResponseDTO {

    private Long id;
    private String codiceFiscale;
    private String nome;
    private String congome;
    private List<Modulo> moduliStudente;
    private Academy academy;


}
