package it.unikey.assessmentjava.DAL.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="modulo")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String argomenti;

    @ManyToOne(cascade = CascadeType.ALL)
    private Docente docente;

    private LocalDate datadiInizio;
    private LocalDate datadiFine;

    @ManyToOne(cascade = CascadeType.ALL)
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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public LocalDate getDatadiInizio() {
        return datadiInizio;
    }

    public void setDatadiInizio(LocalDate datadiInizio) {
        this.datadiInizio = datadiInizio;
    }

    public LocalDate getDatadiFine() {
        return datadiFine;
    }

    public void setDatadiFine(LocalDate datadiFine) {
        this.datadiFine = datadiFine;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }
}
