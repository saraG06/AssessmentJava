package it.unikey.assessmentjavaleonardopaolini.BLL.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloRequestDTO {

    private String nome;

    private String argomento;

    private LocalDate datainizio;

    private LocalDate datafine;

    private DocenteRequestDTO docenteRequestDTO;

    private AcademyRequestDTO academyRequestDTO;

}
