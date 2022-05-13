package it.unikey.assessmentjava.BLL.DTO.request;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyRequestDTO {

    private String nome;
    private LocalDate datadiInizio;
    private LocalDate datadiFine;

    private List<DiscenteRequestDTO> discenteRequestDTOList;
}
