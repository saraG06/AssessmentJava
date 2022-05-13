package it.unikey.assessmentjava.BLL.dto.response;

import lombok.Data;

@Data
public class DiscentiResponseDTO {
    Long id_discente;
    private String nome;
    private String cognome;
    private String codice_fiscale;
    private AcademyResponseDTO academy;

}
