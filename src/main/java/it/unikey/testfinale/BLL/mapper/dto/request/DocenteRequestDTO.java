package it.unikey.testfinale.BLL.mapper.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class DocenteRequestDTO {

    private String nome;
    private String cognome;
    private String email;
    private List<ModuloRequestDTO> moduloRequestDTOList;
}
