package it.unikey.assestmentjava.BLL.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AcademyRequestDTO {

    private String nome;
    private LocalDate datainizio;
    private LocalDate datafine;

    public void setDatainizio(LocalDate datainizio) {
        if(datainizio.isAfter(LocalDate.now()) && datainizio.isBefore(datafine)) {
            this.datainizio = datainizio;
        }
    }

    public void setDatafine(LocalDate datafine) {
        if(datafine.isAfter(datainizio)) {
            this.datafine = datafine;
        }
    }
}
