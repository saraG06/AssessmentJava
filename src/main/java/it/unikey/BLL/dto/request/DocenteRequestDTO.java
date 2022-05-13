package it.unikey.BLL.dto.request;

import lombok.Data;

@Data
public class DocenteRequestDTO {
    private String nome;
    private String cognome;
    private ModuloRequestDTO moduloRequestDTO;
    private AcademyRequestDTO academyRequestDTO;
}
