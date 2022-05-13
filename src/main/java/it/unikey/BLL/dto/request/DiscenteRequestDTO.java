package it.unikey.BLL.dto.request;

import lombok.Data;

@Data
public class DiscenteRequestDTO {
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private AcademyRequestDTO academyRequestDTO;
}
