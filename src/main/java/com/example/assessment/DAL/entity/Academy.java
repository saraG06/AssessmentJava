package com.example.assessment.DAL.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;

    @OneToMany(mappedBy = "academy")
    private List<Modulo> listaModulo;

    @OneToMany(mappedBy = "academy")
    private List<Discente> listaDiscente;

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

    public List<Modulo> getListaModulo() {
        return listaModulo;
    }

    public void setListaModulo(List<Modulo> listaModulo) {
        this.listaModulo = listaModulo;
    }

    public List<Discente> getListaDiscente() {
        return listaDiscente;
    }

    public void setListaDiscente(List<Discente> listaDiscente) {
        this.listaDiscente = listaDiscente;
    }

    @Override
    public String toString() {
        return "Academy{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", listaModulo=" + listaModulo +
                ", listaDiscente=" + listaDiscente +
                '}';
    }
}
