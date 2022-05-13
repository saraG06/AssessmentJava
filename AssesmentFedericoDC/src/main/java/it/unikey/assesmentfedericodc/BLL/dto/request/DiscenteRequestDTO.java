package it.unikey.assesmentfedericodc.BLL.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class DiscenteRequestDTO implements Serializable {

    private String nome;
    private String cognome;
    private String codiceFiscale;

    private AcademyRequestDTO academyRequestDTO;
}
