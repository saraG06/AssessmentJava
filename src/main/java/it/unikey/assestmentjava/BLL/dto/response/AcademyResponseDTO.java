package it.unikey.assestmentjava.BLL.dto.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class AcademyResponseDTO {

    private Long id;
    private String nome;
    private LocalDate data_inizio;
    private LocalDate data_fine;
}
