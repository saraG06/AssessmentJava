package it.unikey.BLL.dto.response;

import lombok.Data;

@Data
public class DiscenteResponseDTO {
    private Long id;
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private AcademyResponseDTO academyResponseDTO;
}
