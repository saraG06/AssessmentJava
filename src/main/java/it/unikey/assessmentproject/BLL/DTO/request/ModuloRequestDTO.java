package it.unikey.assessmentproject.BLL.DTO.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloRequestDTO {

    private Long id;
    private String nome;
    private LocalDate inizioModulo;
    private LocalDate fineModulo;


}
