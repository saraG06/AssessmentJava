package it.unikey.assessmentjavaleonardopaolini.BLL.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AcademyRequestDTO {

    private String nome;

    private LocalDate datainizio;

    private LocalDate datafine;


}
