package com.example.assessmentjava.DAL.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "modulo")
@Entity
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "argomento", nullable = false)
    private String argomento;
    @Column(name = "docente", nullable = false)
    private String docente;
    @Column(name = "dataInizioModulo", nullable = false)
    private LocalDate dataInizioModulo;
    @Column(name = "dataFineModulo", nullable = false)
    private LocalDate dataFineModulo;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
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
