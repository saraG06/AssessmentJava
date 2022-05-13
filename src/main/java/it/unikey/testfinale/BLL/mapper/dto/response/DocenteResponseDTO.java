package it.unikey.testfinale.BLL.mapper.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class DocenteResponseDTO {

    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private List<ModuloResponseDTO> moduloResponseDTOList;
}
