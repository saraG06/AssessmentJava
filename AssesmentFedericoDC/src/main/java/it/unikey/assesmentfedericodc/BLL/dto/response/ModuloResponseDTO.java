package it.unikey.assesmentfedericodc.BLL.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ModuloResponseDTO implements Serializable {

    private Long id;
    private String nome;
    private String argomenti;
    private String docente;
    private LocalDate dataInizio;
    private LocalDate dataFine;
  //  private AcademyResponseDTO academyResponseDTO;

}
