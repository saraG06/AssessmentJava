package com.example.assessmentjava.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id di academy", example = "1", required = true)

    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name = "dataInizio")
    private LocalDate dataInizio;

    @Column(name = "dataFine")
    private LocalDate dataFine;

    @OneToMany(mappedBy = "academy", fetch = FetchType.LAZY)
   private List<Modulo> modulo;

    @OneToMany(mappedBy = "academy", fetch = FetchType.LAZY)
    private List<Discente> discente;

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

    public List<Modulo> getModulo() {
        return modulo;
    }

   public void setModulo(List<Modulo> modulo) {
        this.modulo = modulo;
    }

   public List<Discente> getDiscente() {
        return discente;
    }

    public void setDiscente(List<Discente> discente) {
        this.discente = discente;
   }
}
