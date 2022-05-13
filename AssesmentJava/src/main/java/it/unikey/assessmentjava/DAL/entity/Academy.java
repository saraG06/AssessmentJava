package it.unikey.assessmentjava.DAL.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name ="academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "datadiinizio")
    private LocalDate datadiInizio;
    @Column(name = "datadifine")
    private LocalDate datadiFine;

    @OneToMany(mappedBy = "academy")
    private List<Modulo> moduli;
    @OneToMany(mappedBy = "academy", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER)
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

    public List<Modulo> getModuli() {
        return moduli;
    }

    public void setModuli(List<Modulo> moduli) {
        this.moduli = moduli;
    }

    public List<Discente> getDiscenti() {
        return discenti;
    }

    public void setDiscenti(List<Discente> discenti) {
        this.discenti = discenti;
    }
}
