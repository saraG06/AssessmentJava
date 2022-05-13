package it.unikey.assessmentproject.BLL.DTO.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class AcademyResponseDTO {

    private String nome;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate inizio;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fine;
    private List<DiscenteResponseDTO> discenteResponseDTOList;
    private List<ModuloResponseDTO> moduloResponseDTOList;

}
