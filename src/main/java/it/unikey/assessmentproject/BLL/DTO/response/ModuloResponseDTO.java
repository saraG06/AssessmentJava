package it.unikey.assessmentproject.BLL.DTO.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloResponseDTO {

    private String codiceFiscale;
    private String nome;
    private String cognome;
    private LocalDate inizioModulo;
    private LocalDate fineModulo;
}
