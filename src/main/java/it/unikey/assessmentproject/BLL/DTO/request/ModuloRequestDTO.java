package it.unikey.assessmentproject.BLL.DTO.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloRequestDTO {

    private Long id;
    private String nome;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate inizioModulo;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fineModulo;


}
