package it.unikey.assessmentproject.BLL.DTO.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyRequestDTO {

    private Long id;
    private String nome;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate inizio;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fine;

    private List<DiscenteRequestDTO> discenteRequestDTOList;
    private List<ModuloRequestDTO> moduloRequestDTOList;

}
