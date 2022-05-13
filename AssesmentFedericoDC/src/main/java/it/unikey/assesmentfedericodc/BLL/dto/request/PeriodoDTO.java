package it.unikey.assesmentfedericodc.BLL.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PeriodoDTO {
    private LocalDate dataMin ;
    private LocalDate dataMax ;
}
