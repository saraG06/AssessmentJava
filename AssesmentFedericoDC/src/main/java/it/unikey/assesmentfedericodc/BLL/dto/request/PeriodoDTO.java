package it.unikey.assesmentfedericodc.BLL.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PeriodoDTO {
    //dto serve per la query delle date comprese
    //passo il dto nel body della chiamata http
    private LocalDate dataMin ;
    private LocalDate dataMax ;
}
