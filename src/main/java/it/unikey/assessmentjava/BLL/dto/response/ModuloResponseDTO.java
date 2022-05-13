package it.unikey.assessmentjava.BLL.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloResponseDTO {
    Long id_modulo;
    private String argomenti;
    private LocalDate data_inizio_modulo;
    private LocalDate data_fine_modulo;
    private DocenteResponseDTO docente;
    private AcademyResponseDTO academy;

}
