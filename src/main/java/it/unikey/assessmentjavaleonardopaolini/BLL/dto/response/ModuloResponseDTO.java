package it.unikey.assessmentjavaleonardopaolini.BLL.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloResponseDTO {

    private Long id;

    private String nome;

    private String argomento;

    private LocalDate datainizio;

    private LocalDate datafine;

    private DocenteResponseDTO docenteResponseDTO;

    private AcademyResponseDTO academyResponseDTO;
}
