package it.unikey.BLL.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import it.unikey.DAL.entity.Discente;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AcademyRequestDTO {
    private String nome;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataInizio;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataFine;

    private List<DocenteRequestDTO> docenteRequestDTOList;
    private List<DiscenteRequestDTO> discenteRequestDTOList;
}
