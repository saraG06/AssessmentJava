package it.unikey.assestmentjava.BLL.dto.request;

import lombok.Data;

@Data
public class PersonaRequestDTO {

    private String cf;
    private String nome;
    private String cognome;

    public void setCf(String cf) {
        if(cf.length() == 16){
            this.cf = cf;
        }
    }
}
