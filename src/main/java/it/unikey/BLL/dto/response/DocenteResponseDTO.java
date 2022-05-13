package it.unikey.BLL.dto.response;

import lombok.Data;

@Data
public class DocenteResponseDTO {
    private Long id;
    private String nome;
    private String cognome;
    private ModuloResponseDTO moduloResponseDTO;
    private AcademyResponseDTO academyResponseDTO;
}
