package it.unikey.assessmentjavaleonardopaolini.BLL.dto.response;

import java.time.LocalDate;

public class ModuloResponseDTO {

    private Long id;

    private String nome;

    private String argomento;

    private LocalDate datainzio;

    private LocalDate datafine;

    private DocenteResponseDTO docenteResponseDTO;

    private AcademyResponseDTO academyResponseDTO;
}
