package it.unikey.assestmentjava.BLL.dto.response;

import it.unikey.assestmentjava.BLL.dto.request.AcademyRequestDTO;
import it.unikey.assestmentjava.BLL.dto.request.DocenteRequestDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloResponseDTO {

    private Long id;
    private String nome;
    private String argomenti;
    private DocenteResponseDTO docenteResponseDTO;
    private LocalDate data_inizio;
    private LocalDate data_fine;
    private AcademyResponseDTO academyResponseDTO;
}
