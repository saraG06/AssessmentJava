package it.unikey.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "discente")
public class Discente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "Id Discente", example = "2", required = true)
    private Long id;

    @Column(name = "codiceFiscale", nullable = false)
    @ApiModelProperty(notes= "CodiceFiscale Discente", example = "ACH234CVB21D212A", required = true)
    private String codiceFiscale;

    @Column(name = "nome",nullable = false)
    @ApiModelProperty(notes= "Nome Discente", example = "Mario", required = true)
    private String nome;

    @Column(name = "cognome", nullable = false)
    @ApiModelProperty(notes= "Cognome Discente", example = "Rossi", required = true)
    private String cognome;

    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "Relazione ManyToOne con Academy", required = true)
    private Academy academy;
}
