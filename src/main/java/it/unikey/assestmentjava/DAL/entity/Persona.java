package it.unikey.assestmentjava.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cf", nullable = false, unique = true, length = 16)
    @ApiModelProperty(notes = "E' il Codice Fiscale e deve avere esattamente 16 caratteri", required = true)
    private String cf;
    @Column(name = "nome", nullable = false)
    @ApiModelProperty(notes = "Nome del Discente/Docente", required = true)
    private String nome;
    @Column(name = "cognome", nullable = false)
    @ApiModelProperty(notes = "Cognome del Discente/Docente", required = true)
    private String cognome;
}
