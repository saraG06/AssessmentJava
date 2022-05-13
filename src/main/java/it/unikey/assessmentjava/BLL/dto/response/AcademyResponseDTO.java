package it.unikey.assessmentjava.BLL.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyResponseDTO {
    private Long id_academy;
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<ModuloResponseDTO> modulo;
    private List<DiscentiResponseDTO> discente;

}
