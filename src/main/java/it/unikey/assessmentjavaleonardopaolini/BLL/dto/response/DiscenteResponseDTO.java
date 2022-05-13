package it.unikey.assessmentjavaleonardopaolini.BLL.dto.response;

import lombok.Data;

@Data
public class DiscenteResponseDTO {

    private Long id;

    private String cv;

    private String nome;

    private String cognome;

    private AcademyResponseDTO academyResponseDTO;

}
