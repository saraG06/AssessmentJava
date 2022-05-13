package it.unikey.assesmentfedericodc.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "modulo")
@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "ID academy", example= "1", required = true)
    private Long id ;
    @Column(name = "nome",nullable = false)
    @ApiModelProperty(notes= "nome modulo", example= "Database", required = true)
    private String nome;

    @Column(name = "docente",nullable = false)
    @ApiModelProperty(notes= "nome e cognome docente modulo", example= "Mario Rossi", required = true)
    private String docente;

    @Column(name = "argomenti")
    @ApiModelProperty(notes= "argomenti del modulo", example= "Sql server,transaction,modello entity-relationship")
    private String argomenti ;

    @Column(name = "dataInizio",nullable = false)
    @ApiModelProperty(notes= "data inizio modulo", example= "2022-03-20", required = true)
    private LocalDate dataInizio;
    @Column(name = "dataFine",nullable = false)
    @ApiModelProperty(notes= "data fine modulo", example= "2022-08-22", required = true)
    private LocalDate dataFine;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="academy_id" )
    @ApiModelProperty(notes= "relazione ManyToOne con academy", required = true)
    private Academy academy;
}
