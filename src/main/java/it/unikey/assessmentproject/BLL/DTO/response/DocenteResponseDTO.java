package it.unikey.assessmentproject.BLL.DTO.response;

import lombok.Data;

import java.util.List;

@Data
public class DocenteResponseDTO {

    private String nome;
    private String cognome;
    private List<ModuloResponseDTO> moduloResponseDTOList;

}
