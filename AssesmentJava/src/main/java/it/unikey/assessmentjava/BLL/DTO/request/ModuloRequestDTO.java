package it.unikey.assessmentjava.BLL.DTO.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloRequestDTO {

    private String nome;
    private String argomenti;
    private LocalDate datadiInizio;
    private LocalDate datadiFine;

    private DocenteRequestDTO docenteRequestDTO;
    private AcademyRequestDTO academyRequestDTO;
}
