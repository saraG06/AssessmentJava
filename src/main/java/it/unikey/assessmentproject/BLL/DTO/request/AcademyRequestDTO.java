package it.unikey.assessmentproject.BLL.DTO.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyRequestDTO {

    private Long id;
    private String nome;
    private LocalDate inizio;
    private LocalDate fine;
    private List<DiscenteRequestDTO> discenteRequestDTOList;
    private List<ModuloRequestDTO> moduloRequestDTOList;

}
