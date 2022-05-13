package it.unikey.assessmentjava.BLL.dto.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.unikey.assessmentjava.BLL.dto.response.DiscentiResponseDTO;
import it.unikey.assessmentjava.BLL.dto.response.ModuloResponseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@ApiModel
public class AcademyRequestDTO {
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    @ApiModelProperty(notes = "Questa è la relazione con modulo", example= "Chiara Tortorella", required = false)
    private List<ModuloResponseDTO> modulo;

    @ApiModelProperty(notes = "Questa è la relazione con discente", example= "Chiara Tortorella", required = false)
    private List<DiscentiResponseDTO> discente;
}
