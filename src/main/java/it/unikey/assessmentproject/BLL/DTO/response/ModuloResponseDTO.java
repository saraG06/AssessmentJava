package it.unikey.assessmentproject.BLL.DTO.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloResponseDTO {

    private String codiceFiscale;
    private String nome;
    private String cognome;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate inizioModulo;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fineModulo;
}
