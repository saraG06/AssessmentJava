package it.unikey.assessmentjavaleonardopaolini.BLL.dto.request;

import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.AcademyResponseDTO;
import it.unikey.assessmentjavaleonardopaolini.BLL.dto.response.DocenteResponseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloRequestDTOCreazione {

    private String nome;

    private String argomento;

    private LocalDate datainizio;

    private LocalDate datafine;

    private DocenteResponseDTO docenteResponseDTO;

    private AcademyResponseDTO academyResponseDTO;
}
