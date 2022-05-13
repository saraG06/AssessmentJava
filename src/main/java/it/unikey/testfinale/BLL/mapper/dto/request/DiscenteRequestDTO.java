package it.unikey.testfinale.BLL.mapper.dto.request;

import lombok.Data;

@Data
public class DiscenteRequestDTO {

    private String CF;
    private String nome;
    private String cognome;
    private AcademyRequestDTO academyRequestDTO;

}
