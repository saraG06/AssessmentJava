package com.example.assessmentjava.DAL.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "modulo")

public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "argomenti")
    private String argomenti;

    @Column(name = "docente")
    private String docente;

    @Column(name = "dataInizioModulo")
    private LocalDate dataInizioModulo;

    @Column(name = "dataFineModulo")
    private LocalDate dataFineModulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "academy", nullable = false)
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

    public String getArgomenti() {
        return argomenti;
    }

    public void setArgomenti(String argomenti) {
        this.argomenti = argomenti;
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
