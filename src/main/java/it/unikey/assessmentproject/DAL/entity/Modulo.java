package it.unikey.assessmentproject.DAL.entity;

import org.yaml.snakeyaml.events.DocumentEndEvent;

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
    @Column(name = "inizio_modulo")
    private LocalDate inizioModulo;
    @Column(name = "fine_modulo")
    private LocalDate fineModulo;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "docente_id")
    private Docente docente;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "academy_id")
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

    public LocalDate getInizioModulo() {
        return inizioModulo;
    }

    public void setInizioModulo(LocalDate inizioModulo) {
        this.inizioModulo = inizioModulo;
    }

    public LocalDate getFineModulo() {
        return fineModulo;
    }

    public void setFineModulo(LocalDate fineModulo) {
        this.fineModulo = fineModulo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }
}
