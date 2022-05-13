package it.unikey.assesmentfedericodc.BLL.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AccademyRequestDTO implements Serializable {

    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
}
