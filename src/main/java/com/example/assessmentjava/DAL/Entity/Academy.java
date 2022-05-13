package com.example.assessmentjava.DAL.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "academy")
@Entity
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "dataInizio",nullable = false)
    private LocalDate dataInizio;
    @Column(name = "dataFine",nullable = false)
    private LocalDate dataFine;
    @OneToMany(mappedBy = "academy",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<Modulo> moduloList;
    @OneToMany(mappedBy = "academy",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
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
