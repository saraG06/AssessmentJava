package com.example.assessmentfinale.DAL.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "modulo")
public class Modulo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "programma")
    private String programma;

    @Column (name = "docente") // se c'è tempo, fare entity
    private String docente;

    @Column (name = "data_inizio")
    private LocalDate dataInizio;

    @Column (name = "data_fine")
    private LocalDate dataFine;

    @ManyToMany //creo una tabella per vedere tutti i discenti in quale modulo sono registrati.
    //fare una cosa simile ma onetomany perché non possono fare due academy
    @JoinTable (
            name = "discenti_modulo",
            joinColumns = @JoinColumn (name = "modulo_id"),
            inverseJoinColumns = @JoinColumn(name = "discente_id" )
    )
    private List<Discente> discentiModulo;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "academy_id", referencedColumnName = "id", nullable = false)
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

    public String getProgramma() {
        return programma;
    }

    public void setProgramma(String programma) {
        this.programma = programma;
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

    public List<Discente> getDiscentiModulo() {
        return discentiModulo;
    }

    public void setDiscentiModulo(List<Discente> discentiModulo) {
        this.discentiModulo = discentiModulo;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }
}
