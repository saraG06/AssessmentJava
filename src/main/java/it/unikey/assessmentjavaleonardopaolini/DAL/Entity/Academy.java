package it.unikey.assessmentjavaleonardopaolini.DAL.Entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false,unique = true)
    private String nome;

    @Column(name = "datainizio",nullable = false)
    private LocalDate datainizio;

    @Column(name = "datafine",nullable = false)
    private LocalDate datafine;

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

    @Override
    public String toString() {
        return "Academy{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", datainizio=" + datainizio +
                ", datafine=" + datafine +
                '}';
    }
}
