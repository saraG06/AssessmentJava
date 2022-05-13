package it.unikey.assessmentproject.DAL.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "inizio")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate inizio;
    @Column(name = "fine")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fine;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "academy")
    private List<Discente> discenteList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "academy")
    private List<Modulo> moduloList;

    public Academy() {
    }

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

    public LocalDate getInizio() {
        return inizio;
    }

    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }

    public LocalDate getFine() {
        return fine;
    }

    public void setFine(LocalDate fine) {
        this.fine = fine;
    }

    public List<Discente> getDiscenteList() {
        return discenteList;
    }

    public void setDiscenteList(List<Discente> discenteList) {
        this.discenteList = discenteList;
    }

    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
    }
}
