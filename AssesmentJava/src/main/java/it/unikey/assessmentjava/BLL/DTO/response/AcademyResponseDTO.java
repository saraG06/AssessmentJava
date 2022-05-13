package it.unikey.assessmentjava.BLL.DTO.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AcademyResponseDTO {

    private Long id;
    private String nome;
    private LocalDate datadiInizio;
    private LocalDate datadiFine;
}
