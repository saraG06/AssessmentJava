package com.example.assessmentfinale.BLL.dto.response;

import com.example.assessmentfinale.DAL.entities.Discente;
import com.example.assessmentfinale.DAL.entities.Modulo;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyResponseDTO {

    private Long id;
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<Modulo> moduli;
    private List<Discente> discenti;


}
