package it.unikey.assesmentfedericodc.BLL.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class AccademyRequestDTO implements Serializable {

    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<DiscenteRequestDTO> discenteRequestDTOList;
    private List<ModuloRequestDTO> moduloRequestDTOList;
}
