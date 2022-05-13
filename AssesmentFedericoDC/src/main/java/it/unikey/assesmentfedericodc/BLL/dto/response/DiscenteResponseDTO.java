package it.unikey.assesmentfedericodc.BLL.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class DiscenteResponseDTO implements Serializable {
    private String nome;
    private String cognome;
    private String codiceFiscale;

    private AccademyResponseDTO accademyResponseDTO;
}
