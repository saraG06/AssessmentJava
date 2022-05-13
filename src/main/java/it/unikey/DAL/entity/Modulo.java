package it.unikey.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "modulo")
public class Modulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "Id Modulo", example = "3", required = true)
    private Long id;

    @Column(name = "nome", nullable = false)
    @ApiModelProperty(notes= "Nome Modulo", example = "Front-End", required = true)
    private String nome;

    @Column(name = "argomenti", nullable = false)
    @ApiModelProperty(notes= "Argomenti Modulo", example = "Design Pattern, etc...", required = true)
    private String argomenti;

    @Column(name = "dataInizio", nullable = false)
    @ApiModelProperty(notes= "Data di Inizio Modulo", example = "2002-01-01", required = true)
    private LocalDate dataInizio;

    @Column(name = "dataFine")
    @ApiModelProperty(notes= "Data di Fine Modulo", example = "2003-01-01", required = true)
    private LocalDate dataFine;

    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "Relazione ManyToOne con Academy", required = true)
    private Academy academy;
}
