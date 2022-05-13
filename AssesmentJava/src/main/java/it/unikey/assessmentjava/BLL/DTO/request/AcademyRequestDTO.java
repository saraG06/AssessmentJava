package it.unikey.assessmentjava.BLL.DTO.request;


import lombok.Data;

import java.time.LocalDate;

@Data
public class AcademyRequestDTO {

    private String nome;
    private LocalDate datadiInizio;
    private LocalDate datadiFine;
}
