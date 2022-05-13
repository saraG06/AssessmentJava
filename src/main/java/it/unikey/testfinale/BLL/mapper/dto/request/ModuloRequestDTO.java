package it.unikey.testfinale.BLL.mapper.dto.request;

import it.unikey.testfinale.DAL.Entity.Docente;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloRequestDTO {

    private String nome;
    private String argomenti;
    private Docente docente;
    private LocalDate inizio;
    private LocalDate fine;
}
