package it.unikey.assessmentjava.BLL.dto.request;

import it.unikey.assessmentjava.BLL.dto.response.ModuloResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class DocenteRequestDTO {
    private String nome;
    private List<ModuloRequestDTO> moduli;
}
