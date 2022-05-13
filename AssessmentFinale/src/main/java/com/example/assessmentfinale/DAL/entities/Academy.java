package com.example.assessmentfinale.DAL.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "academy")
public class Academy {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "data_inizio")
    private LocalDate dataInizio;

    @Column (name = "data_fine")
    private LocalDate dataFine;

    @OneToMany (mappedBy = "academy")
    private List<Modulo> moduli;

    @OneToMany (mappedBy = "academy")
    private List<Discente> discenti;

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

    public List<Modulo> getModuli() {
        return moduli;
    }

    public void setModuli(List<Modulo> moduli) {
        this.moduli = moduli;
    }

    public List<Discente> getDiscenti() {
        return discenti;
    }

    public void setStudenti(List<Discente> discenti) {
        this.discenti = discenti;
    }

    @Override //è il punto 5?
    public String toString() {
        return "Academy{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", moduli=" + moduli +
                ", discenti=" + discenti +
                '}';
    }
}
