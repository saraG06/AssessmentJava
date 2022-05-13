package it.unikey.assessmentjava.BLL.DTO.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloResponseDTO {

    private Long id;
    private String nome;
    private String argomenti;
    private LocalDate datadiInizio;
    private LocalDate datadiFine;

    private DiscenteResponseDTO discenteResponseDTO;
    private AcademyResponseDTO academyResponseDTO;
}
