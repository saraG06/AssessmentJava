package it.unikey.assessmentjava.BLL.dto.request;
import it.unikey.assessmentjava.BLL.dto.response.DiscentiResponseDTO;
import it.unikey.assessmentjava.BLL.dto.response.ModuloResponseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyRequestDTO {
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<ModuloResponseDTO> modulo;
    private List<DiscentiResponseDTO> discente;
}
