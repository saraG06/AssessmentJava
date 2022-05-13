package it.unikey.testfinale.BLL.mapper.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyResponseDTO {

    private Long id;
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<ModuloResponseDTO> moduloResponseDTOList;
    private List<DiscenteResponseDTO> discenteResponseDTOList;
}
