package com.example.assessmentjava.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "academy")
@Entity
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "ID academy", example= "1", required = true)
    private Long id;
    @Column(name = "nome", nullable = false)
    @ApiModelProperty(notes= "nome academy", example= "java2022", required = true)
    private String nome;
    @Column(name = "dataInizio",nullable = false)
    @ApiModelProperty(notes= "data inizio academy", example= "2022-15-28", required = true)
    private LocalDate dataInizio;
    @Column(name = "dataFine",nullable = false)
    @ApiModelProperty(notes= "data fine academy", example= "2022-11-02", required = true)
    private LocalDate dataFine;
    @OneToMany(mappedBy = "academy",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @ApiModelProperty(notes = "relazione con lista Moduli")
    private List<Modulo> moduloList;
    @OneToMany(mappedBy = "academy",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @ApiModelProperty(notes = "relazione con lista Discenti")
    private List<Discente> discenteList;

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

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
    }

    public List<Discente> getDiscenteList() {
        return discenteList;
    }

    public void setDiscenteList(List<Discente> discenteList) {
        this.discenteList = discenteList;
    }
}
