package it.unikey.assessmentjava.BLL.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class DocenteResponseDTO {
    Long id_docente;
    private String nome;
    private List<ModuloResponseDTO> moduli;

}
