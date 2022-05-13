package it.unikey.testfinale.BLL.mapper.dto.response;

import it.unikey.testfinale.DAL.Entity.Docente;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloResponseDTO {

    private Long id;
    private String nome;
    private String argomenti;
    private DocenteResponseDTO docenteResponseDTO;
    private LocalDate inizio;
    private LocalDate fine;
    private AcademyResponseDTO academyResponseDTO;
}
