package it.unikey.assessmentjava.BLL.dto.request;

import it.unikey.assessmentjava.BLL.dto.response.AcademyResponseDTO;
import lombok.Data;

@Data
public class DiscentiRequestDTO {
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private AcademyRequestDTO academy;
}
