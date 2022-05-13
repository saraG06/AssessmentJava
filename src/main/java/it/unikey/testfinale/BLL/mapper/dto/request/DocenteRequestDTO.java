package it.unikey.testfinale.BLL.mapper.dto.request;

import it.unikey.testfinale.DAL.Entity.Modulo;
import lombok.Data;

import java.util.List;

@Data
public class DocenteRequestDTO {

    private String nome;
    private String cognome;
    private String email;
    private List<Modulo> moduloList;
}
