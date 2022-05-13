package it.unikey.assesmentfedericodc.BLL.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyResponseDTO implements Serializable {

    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    List<DiscenteResponseDTO> discenteResponseDTOList;
    List<ModuloResponseDTO> moduloResponseDTOList;
}
