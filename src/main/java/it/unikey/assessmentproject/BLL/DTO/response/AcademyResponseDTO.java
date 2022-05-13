package it.unikey.assessmentproject.BLL.DTO.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class AcademyResponseDTO {

    private String nome;
    private LocalDate inizio;
    private LocalDate fine;
    private List<DiscenteResponseDTO> discenteResponseDTOList;
    private List<ModuloResponseDTO> moduloResponseDTOList;

}
