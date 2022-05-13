package it.unikey.assessmentjavaleonardopaolini.DAL.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "modulo")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false,unique = true)
    private String nome;

    @Column(name = "argomento",nullable = false)
    private String argomento;

    @Column(name = "datainizio",nullable = false)
    private LocalDate datainizio;

    @Column(name = "datafine",nullable = false)
    private LocalDate datafine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "docente", nullable = false)
    private Docente docente;

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

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public LocalDate getDatainizio() {
        return datainizio;
    }

    public void setDatainizio(LocalDate datainizio) {
        this.datainizio = datainizio;
    }

    public LocalDate getDatafine() {
        return datafine;
    }

    public void setDatafine(LocalDate datafine) {
        this.datafine = datafine;
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

    @Override
    public String toString() {
        return "Modulo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", argomento='" + argomento + '\'' +
                ", datainizio=" + datainizio +
                ", datafine=" + datafine +
                ", docente=" + docente +
                ", academy=" + academy +
                '}';
    }
}
