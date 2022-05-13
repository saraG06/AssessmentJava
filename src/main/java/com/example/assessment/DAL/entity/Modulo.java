package com.example.assessment.DAL.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Modulo")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "argomento")
    private String argomento;

    @Column(name = "docente")
    private String docente;

    @Column(name = "data_inizio_modulo")
    private LocalDate dataInizio;

    @Column(name = "data_fine_modulo")
    private LocalDate dataFine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "academy_id", referencedColumnName = "id", nullable = false)
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

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", argomento='" + argomento + '\'' +
                ", docente='" + docente + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", academy=" + academy +
                '}';
    }
}
