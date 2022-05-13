package com.example.assessmentjava.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "modulo")
@Entity
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "ID academy", example= "1", required = true)
    private Long id;
    @Column(name = "nome", nullable = false)
    @ApiModelProperty(notes= "nome modulo", example= "Backend", required = true)
    private String nome;
    @Column(name = "argomento", nullable = false)
    @ApiModelProperty(notes= "argomenti del modulo", example= "Java")
    private String argomento;
    @Column(name = "docente", nullable = false)
    @ApiModelProperty(notes= "nome e cognome docente", example= "peppe braida", required = true)
    private String docente;
    @Column(name = "dataInizioModulo", nullable = false)
    @ApiModelProperty(notes= "data inizio modulo", example= "2022-05-13", required = true)
    private LocalDate dataInizioModulo;
    @Column(name = "dataFineModulo", nullable = false)
    @ApiModelProperty(notes= "data fine modulo", example= "2022-01-24", required = true)
    private LocalDate dataFineModulo;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @ApiModelProperty(notes= "relazione con academy", required = true)
    @JoinColumn(name="academy_id")
    private Academy academy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public LocalDate getDataInizioModulo() {
        return dataInizioModulo;
    }

    public void setDataInizioModulo(LocalDate dataInizioModulo) {
        this.dataInizioModulo = dataInizioModulo;
    }

    public LocalDate getDataFineModulo() {
        return dataFineModulo;
    }

    public void setDataFineModulo(LocalDate dataFineModulo) {
        this.dataFineModulo = dataFineModulo;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }
}
