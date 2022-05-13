package it.unikey.assessmentjava.BLL.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloRequestDTO {
    private String argomenti;
    private LocalDate data_inizio_modulo;
    private LocalDate data_fine_modulo;
    private DocenteRequestDTO docente;
    private AcademyRequestDTO academy;
}
