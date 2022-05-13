package it.unikey.assessmentproject.BLL.DTO.request;

import lombok.Data;

import java.util.List;

@Data
public class DocenteRequestDTO {

    private Long id;
    private String nome;
    private String cognome;
    private List<ModuloRequestDTO> moduloRequestDTOList;


}
