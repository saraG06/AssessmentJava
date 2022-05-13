package it.unikey.testfinale.BLL.mapper.dto.response;

import lombok.Data;

@Data
public class DiscenteResponseDTO {

    private Long id;
    private String CF;
    private String nome;
    private String cognome;
    private AcademyResponseDTO academyResponseDTO;
}
