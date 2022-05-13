package it.unikey.assestmentjava.BLL.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuloRequestDTO {

    private String nome;
    private String argomenti;
    private DocenteRequestDTO docenteRequestDTO;
    private LocalDate data_inizio;
    private LocalDate data_fine;
    private AcademyRequestDTO academyRequestDTO;

    public void setData_inizio(LocalDate data_inizio) {
        if(data_inizio.isAfter(LocalDate.now()) && data_inizio.isBefore(data_fine)) {
            this.data_inizio = data_inizio;
        }
    }
    public void setData_fine(LocalDate data_fine) {
        if (data_fine.isAfter(data_inizio)) {
            this.data_fine = data_fine;
        }
    }
}
