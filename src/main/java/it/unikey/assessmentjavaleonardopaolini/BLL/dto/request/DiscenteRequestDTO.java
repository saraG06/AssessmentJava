package it.unikey.assessmentjavaleonardopaolini.BLL.dto.request;

import lombok.Data;

@Data
public class DiscenteRequestDTO {

    private String cv;

    private String nome;

    private String cognome;

    private AcademyRequestDTO academyRequestDTO;
}
