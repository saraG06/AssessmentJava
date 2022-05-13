package it.unikey.assesmentfedericodc.BLL.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ModuloRequestDTO implements Serializable {

    private String nome;
    private String argomenti;
    private String docente;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private  AccademyRequestDTO accademyRequestDTO;
}
