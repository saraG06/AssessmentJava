package com.example.assessmentjava.BLL.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class DiscenteResponseDTO implements Serializable {
    private Long id;
    private String codiceFiscale;
    private String nome;
    private String cognome;
}
