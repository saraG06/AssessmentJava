package it.unikey.assessmentjavaleonardopaolini.BLL.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AcademyResponseDTO {

    private Long id;

    private String nome;

    private LocalDate datainizio;

    private LocalDate datafine;
}
