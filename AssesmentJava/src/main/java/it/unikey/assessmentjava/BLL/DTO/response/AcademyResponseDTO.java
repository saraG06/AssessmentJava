package it.unikey.assessmentjava.BLL.DTO.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyResponseDTO {

    private Long id;
    private String nome;
    private LocalDate datadiInizio;
    private LocalDate datadiFine;

    private List<DiscenteResponseDTO> discenteResponseDTOList;
}
